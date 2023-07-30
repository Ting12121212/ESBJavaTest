# ESBJavaTest
資料庫: MS SQL


建Table語法
/*=================================================*/	
CREATE DATABASE ESBJavaTestDB;

USE [ESBJavaTestDB];
GO

/*=================================================*/
-- Users 使用者資料
CREATE TABLE Users(
userID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
userName nvarchar(50) NOT NULL,
email nvarchar(50) UNIQUE NOT NULL,
account nvarchar(50) UNIQUE NOT NULL,
account2 nvarchar(50) UNIQUE NULL
);

/*=================================================*/
-- Products 金融商品資料
CREATE TABLE Products (
no int IDENTITY(1,1) PRIMARY KEY NOT NULL,
productName nvarchar(50) NOT NULL,
price int NOT NULL,
feeRate DECIMAL(3,2) NOT NULL,
description nvarchar(200) NULL,
photo varbinary(max) NULL
);

/*=================================================*/
CREATE TABLE LikeList(
sn int IDENTITY(1,1) PRIMARY KEY NOT NULL,
userID int FOREIGN KEY REFERENCES Users(userID),
productNo int FOREIGN KEY REFERENCES Products(no),
orderName int NOT NULL,
account nvarchar(50) NOT NULL,
totalFee int NOT NULL,
totalAmount int NOT NULL
);



 
建假資料語法

--客戶的假料資料

INSERT INTO [dbo].[Users] ([userName], [email], [account], [account2])
VALUES 
    ('Alex', ' Alex@example.com', 'Alex_account1', 'Alex_account2'),
    ('Bella', 'Bella@example.com', 'Bella_account1', 'Bella_account2'),
    ('Cindy', 'Cindy@example.com', 'Cindy_account1', 'Cindy_account2');

/*=================================================*/
-金融商品的假資料

INSERT INTO [ESBJavaTestDB].[dbo].[Products] ([productName], [price], [feeRate], [description])
VALUES 
    ('美國發財基金', 1000, 0.05, '多元化投資組合，追求長期增長'),
    ('中國發財基金', 2000, 0.10, '穩健收益和資本增值'),
    ('南非發財基金', 1500, 0.15, '投資新興市場，具潛力'),
    ('日本發財基金', 1800, 0.2, '高增長潛力的優質公司'),
    ('德國發財基金', 2500, 0.25, '穩健表現，波動性低');

/*=================================================*/
--喜好紀錄的假資料

INSERT INTO [ESBJavaTestDB].[dbo].[LikeList] ([userID], [productNo], [orderName], [account], [totalFee], [totalAmount])
VALUES
    (1, 1, 1, 'Alex_account1', 50, 1050),
    (2, 2, 2, 'Bella_account1', 400, 4400),
    (2, 4, 3, 'Bella_account2', 1080, 6480),
    (3, 1, 4, 'Cindy_account1', 200, 4200),
	(3, 3, 5, 'Cindy_account2', 1125, 10125),
    (3, 5, 6, 'Cindy_account2', 3750, 18750);
