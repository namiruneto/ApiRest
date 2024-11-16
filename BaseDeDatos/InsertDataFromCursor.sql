
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
		version_id ,
		app_id ,
		version,
		version_description ,
		version_company_id ,
		company_id ,
		version_company_description,
		app_code ,
		app_name,
		app_description 
		from TMP_LLENAR_CAMPOS

		open Ctemporal;

		fetch next from Ctemporal into 
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

				fetch next from Ctemporal 
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

				close Ctemporal;
				deallocate Ctemporal;		
END
GO
