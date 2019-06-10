create database dataBaseTest
on primary
(name = 'newMdfName',filename = 'F:\JavaProductionCenter\biYeSheJi\newMdfName.mdf',size = 2MB,maxsize = 10MB,filegrowth = 2MB)
log on
(name = 'newLogName',filename = 'F:\JavaProductionCenter\biYeSheJi\newLogName.ndf',size = 1MB,maxsize = 5MB,filegrowth = 1MB)
go
use dataBaseTest
go
create table userTable(
    userr char(20) primary key,
    passWordd char(20)
)
go
create table bookTable(
    bookName char(20),
    bookType char(20),
    bookZuoZhe char(20)
)
go
