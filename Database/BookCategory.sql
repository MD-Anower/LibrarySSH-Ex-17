/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[CategoryName]
      ,[Remark]
  FROM [LibraryNewDB].[dbo].[BookCategory]