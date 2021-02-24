/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [Id]
      ,[UserName]
      ,[Password]
  FROM [LibraryNewDB].[dbo].[Users]