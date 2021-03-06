USE [master]
GO
/****** Object:  Database [student]    Script Date: 12/8/2021 5:20:17 PM ******/
CREATE DATABASE [student]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'student', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\student.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'student_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\student_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [student] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [student].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [student] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [student] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [student] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [student] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [student] SET ARITHABORT OFF 
GO
ALTER DATABASE [student] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [student] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [student] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [student] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [student] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [student] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [student] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [student] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [student] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [student] SET  DISABLE_BROKER 
GO
ALTER DATABASE [student] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [student] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [student] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [student] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [student] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [student] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [student] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [student] SET RECOVERY FULL 
GO
ALTER DATABASE [student] SET  MULTI_USER 
GO
ALTER DATABASE [student] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [student] SET DB_CHAINING OFF 
GO
ALTER DATABASE [student] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [student] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [student] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [student] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'student', N'ON'
GO
ALTER DATABASE [student] SET QUERY_STORE = OFF
GO
USE [student]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 12/8/2021 5:20:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[id] [nvarchar](10) NOT NULL,
	[name] [nvarchar](50) NULL,
	[grade] [float] NULL,
	[image] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[notes] [nvarchar](50) NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'12312333', N'Le Hoang Phuc', 3.4000000953674316, N'D://template.txt', N'Ba Hom', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19113333', N'NVBB', 2, N'D://template.txt', N'NVC', N'DT')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19122334', N'NVC', 3.4000000953674316, N'D://template.txt', N'NVC', N'CC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127059', N'NVA', 4, N'D://template.txt', N'NVC', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127122', N'NVD', 3.2000000476837158, N'D://test.png', N'NVC', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127123', N'NVE', 3.9000000953674316, N'D://template.txt', N'NVC', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127125', N'Duong Vu', 3.2000000476837158, N'D://template.txt', N'DBL', N'NVC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127233', N'Tien Quan', 3.0999999046325684, N'D://template.txt', N'DBL', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127234', N'Canh Toan', 2, N'D://template.txt', N'DBL', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127235', N'Huy', 3.2000000476837158, N'D://template.txt', N'Ba Hom', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127236', N'Hieu', 3.2000000476837158, N'D://template.txt', N'Ba Hom', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127237', N'Phuc', 3.0999999046325684, N'D://template.txt', N'BH', N'CLC')
INSERT [dbo].[Student] ([id], [name], [grade], [image], [address], [notes]) VALUES (N'19127238', N'Phuu1', 3.0999999046325684, N'D://template.txt', N'NVC', N'CLC')
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [grade] CHECK  (([grade]>=(0) AND [grade]<=(4)))
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [grade]
GO
USE [master]
GO
ALTER DATABASE [student] SET  READ_WRITE 
GO
