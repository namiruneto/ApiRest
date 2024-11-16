-- Creacion de tablas 
	-- Table company
	CREATE TABLE Company 
	( ID_COMPANY INT PRIMARY KEY,
	  CODIGO_COMPANY VARCHAR(50) UNIQUE NOT NULL,
	  NAME_COMPANY VARCHAR(100) NOT NULL,
	  DESCRIPTION_COMPANY VARCHAR(MAX)
	 );
	
	 Create table version 
	 (
		version_id int Primary key,
		app_id int unique not null,
		version varchar(50) unique not null,
		version_description varchar(max)
	 );
	
	 Create table application
	 (
		app_id int primary key,
		app_code varchar(50) unique not null,
		app_name VARCHAR(100) NOT NULL,
		app_description varchar(max)
	 );
	
	  Create table version_company
	 (
		version_company_id int Primary key,
		company_id int not null,
		version_id int not null,
		version_company_description varchar(max),
			foreign key(company_id)
				references Company(ID_COMPANY),
			foreign key (version_id)
				references version(version_id),
				unique (company_id, version_id)
	 );

--CREACION DE LA TABLA TMP_LLENAR_CAMPOS
	CREATE TABLE TMP_LLENAR_CAMPOS 
	(	id_company INT,
		codigo_company VARCHAR(50),
		name_company VARCHAR(100),
		description_company VARCHAR(MAX),
		version_id INT,
		app_id INT,
		version VARCHAR(50),
		version_description VARCHAR(MAX),
		version_company_id INT,
		company_id INT,
		version_company_description VARCHAR(MAX),
		app_code VARCHAR(50),
		app_name VARCHAR(100),
		app_description VARCHAR(MAX) 
	);

--Procedimiento 

	SET ANSI_NULLS ON
	GO
	SET QUOTED_IDENTIFIER ON
	GO
	-- =============================================
	-- Author:		CESAR FERNANDO CARREÑO PEÑA
	-- Create date: 15/11/2024
	-- Description:	iNSERT
	-- =============================================
	CREATE PROCEDURE InsertDataFromCursor	
AS
BEGIN
Declare @id_company INT,
		@codigo_company VARCHAR(50),
		@name_company VARCHAR(100),
		@description_company VARCHAR(MAX),
		@version_id INT,
		@app_id INT,
		@version VARCHAR(50),
		@version_description VARCHAR(MAX),
		@version_company_id INT,
		@company_id INT,
		@version_company_description VARCHAR(MAX),
		@app_code VARCHAR(50),
		@app_name VARCHAR(100),
		@app_description VARCHAR(MAX) 

		Declare Ctemporal cursor for 
		select 
		id_company,
		codigo_company,
		name_company,
		description_company,
		version_id 
		app_id ,
		version ,
		version_description ,
		version_company_id ,
		company_id ,
		version_company_description,
		app_code ,
		app_name ,
		app_description 
		from TMP_LLENAR_CAMPOS

		open Ctemporal;

		fetch next from ctemporal into 
		@id_company,
		@codigo_company,
		@name_company,
		@description_company,
		@version_id ,
		@app_id ,
		@version ,
		@version_description ,
		@version_company_id ,
		@company_id ,
		@version_company_description,
		@app_code ,
		@app_name ,
		@app_description 

		while @@FETCH_STATUS = 0
		BEGIN 
			if not Exists (select 1 from Company where ID_COMPANY = @id_company)
				begin 
					Insert into company 
						(ID_COMPANY, CODIGO_COMPANY, NAME_COMPANY, DESCRIPTION_COMPANY)
						values(@id_company, @codigo_company, @name_company, @description_company);
				end

			if not exists (select 1 from application where app_id = @app_id)
				begin
					insert into application
						(
							app_id, 
							app_code, 
							app_name,
							app_description
						)
						values 
						(						
							@app_id, 
							@app_code, 
							@app_name,
							@app_description
						);
				end

			if not exists (select 1 from version where version_id = @version_id)
				begin
					insert into version
					(
						version_id,
						app_id,
						version,
						version_description
					)
					values
					(
						@version_id,
						@app_id,
						@version,
						@version_description
					);
				end

			if not exists (select 1 from version_company where version_company_id = @version_company_id)
				begin 
					insert into version_company
					(
						version_company_id,
						company_id,
						version_id,
						version_company_description
					)
					values 
					(
						@version_company_id,
						@company_id,
						@version_id,
						@version_company_description
					);
				end 

				fetch next from ctemporal 
				into 
				@id_company,
				@codigo_company,
				@name_company,
				@description_company,
				@version_id ,
				@app_id ,
				@version ,
				@version_description ,
				@version_company_id ,
				@company_id ,
				@version_company_description,
				@app_code ,
				@app_name ,
				@app_description 
		END 

				close ctemporal;
				deallocate ctemporal;		
END
	GO

-- ejemplo de datos 
	INSERT INTO [dbo].[TMP_LLENAR_CAMPOS]
           ([id_company]
           ,[codigo_company]
           ,[name_company]
           ,[description_company]
           ,[version_id]
           ,[app_id]
           ,[version]
           ,[version_description]
           ,[version_company_id]
           ,[company_id]
           ,[version_company_description]
           ,[app_code]
           ,[app_name]
           ,[app_description])
     VALUES
           (1
           ,'COMPO1'
           ,'COMPANY A'
           ,'DESCRIPCION A'		   
           ,100
           ,400
           ,'APPLICATION A'
           ,'App desc A'
           ,100
           ,1
           ,'iniital Release'
           ,300		   
           ,'Version for company a'
		   ,'Desc Version For Company')
	GO



	exec InsertDataFromCursor

