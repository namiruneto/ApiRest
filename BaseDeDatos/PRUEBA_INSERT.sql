
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


	--EJECUTAR
	exec InsertDataFromCursor

