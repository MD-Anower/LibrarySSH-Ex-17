/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[BookName]
      ,[Picture]
      ,[CategoryId]
      ,[Description]
      ,[Remark]
  FROM [LibraryNewDB].[dbo].[Book]