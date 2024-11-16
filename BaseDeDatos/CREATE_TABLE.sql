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


