/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 8.0.37 : Database - ips
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ips` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ips`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accno` decimal(10,0) DEFAULT NULL,
  `accname` text,
  `balance` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `account` */

/*Table structure for table `admininfos` */

DROP TABLE IF EXISTS `admininfos`;

CREATE TABLE `admininfos` (
  `ID` text,
  `password` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `admininfos` */

insert  into `admininfos`(`ID`,`password`) values 
('Admin','Adminpass'),
('Admin1','Adminpass1');

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `User` text,
  `roomno` decimal(10,0) DEFAULT NULL,
  `buildingNo` decimal(10,0) DEFAULT NULL,
  `bookfrom` text,
  `bookto` text,
  `noofcostumer` decimal(10,0) DEFAULT NULL,
  `Email` text,
  `phno` text,
  `Bookingid` decimal(10,0) NOT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`Bookingid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `booking` */

insert  into `booking`(`User`,`roomno`,`buildingNo`,`bookfrom`,`bookto`,`noofcostumer`,`Email`,`phno`,`Bookingid`,`Price`) values 
('hello',101,1,'2024-06-19','2024-06-20',1,'hello@abc','10123032',1,0),
('hello',203,1,'2024-06-19','2024-06-20',1,'prakharkhede027@gmail.com','2324455',2,0),
('hello',401,1,'2024-06-13','2024-06-19',3,'hello@abc','3456657768',7,300000);

/*Table structure for table `empinfos` */

DROP TABLE IF EXISTS `empinfos`;

CREATE TABLE `empinfos` (
  `empid` decimal(10,0) NOT NULL,
  `empname` text,
  `empdob` text,
  `empgender` text,
  `empphno` text,
  `empemail` text,
  `emppass` text,
  `empjob` text,
  `empsalary` decimal(10,0) DEFAULT NULL,
  `empstatus` text,
  `Dutyat` text,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `empinfos` */

insert  into `empinfos`(`empid`,`empname`,`empdob`,`empgender`,`empphno`,`empemail`,`emppass`,`empjob`,`empsalary`,`empstatus`,`Dutyat`) values 
(101,'Rajan','2002-01-09','Male','5278624354','Rajan@gmail.com','Rajanpass','Sweeper',10000,'Appointed','Room 401');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `emid` decimal(8,3) NOT NULL,
  `emname` text NOT NULL,
  `salary` decimal(10,0) NOT NULL,
  `dpNo` decimal(10,0) DEFAULT NULL,
  `dpName` text NOT NULL,
  PRIMARY KEY (`emid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `employee` */

insert  into `employee`(`emid`,`emname`,`salary`,`dpNo`,`dpName`) values 
(1001.100,'Gopal',80000,101,'WebSite Development'),
(1001.200,'Shyam',85000,101,'WebSite Development'),
(1001.300,'Lalit',75000,101,'WebSite Development'),
(1001.400,'Amit',55000,101,'WebSite Development'),
(1002.100,'Raj',90000,201,'Application Development'),
(1002.200,'Yachana',70000,201,'Application Development'),
(1002.300,'Aryan',89000,201,'Application Development'),
(1002.400,'Balveer',79000,201,'Application Development'),
(1003.100,'Rajat',95000,311,'Server Manager Department'),
(1003.200,'Khushi',71000,311,'Server Manager Department'),
(1003.300,'Yash',87000,311,'Server Manager Department'),
(1003.400,'Vansh',40000,311,'Server Manager Department');

/*Table structure for table `roominfo` */

DROP TABLE IF EXISTS `roominfo`;

CREATE TABLE `roominfo` (
  `roomno` decimal(10,0) NOT NULL,
  `roomtype` text,
  `roomcapacity` decimal(10,0) DEFAULT NULL,
  `roomCPP` decimal(10,0) DEFAULT NULL,
  `bookfrom` text,
  `bookto` text,
  `bookby` text,
  `NoofCostumer` decimal(10,0) DEFAULT NULL,
  `BuldingNo` decimal(10,0) DEFAULT NULL,
  `cheking` text,
  `imagename` text,
  PRIMARY KEY (`roomno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `roominfo` */

insert  into `roominfo`(`roomno`,`roomtype`,`roomcapacity`,`roomCPP`,`bookfrom`,`bookto`,`bookby`,`NoofCostumer`,`BuldingNo`,`cheking`,`imagename`) values 
(202,'Double bad',2,10000,'2024-06-11','2024-06-20','hello',1,1,'n',NULL),
(203,'Double bad',2,10000,'2024-06-19','2024-06-20','hello',1,1,'n',NULL),
(204,'Double bad',2,10000,'2024-06-19','2024-06-20','hello',1,1,'n',NULL),
(301,'Delux',4,50000,NULL,NULL,NULL,NULL,1,'n',NULL),
(302,'Delux',4,50000,NULL,NULL,NULL,NULL,1,'n',NULL),
(303,'Delux',4,50000,NULL,NULL,NULL,NULL,1,'n',NULL),
(304,'Delux',4,50000,NULL,NULL,NULL,NULL,1,'n',NULL),
(401,'Suit Room',8,100000,'2024-06-13','2024-06-19','hello',3,1,'n','room3.jpg'),
(402,'Suit Room',8,100000,NULL,NULL,NULL,NULL,1,'y','room3.jpg'),
(403,'Suit Room',8,100000,NULL,NULL,NULL,NULL,1,'y','room3.jpg'),
(404,'Suit Room',8,100000,NULL,NULL,NULL,NULL,1,'y','room3.jpg');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `roll` decimal(10,0) NOT NULL,
  `name` text NOT NULL,
  `marks` decimal(8,3) DEFAULT NULL,
  PRIMARY KEY (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

insert  into `student`(`roll`,`name`,`marks`) values 
(101,'ram',92.220),
(102,'shyam',93.220),
(103,'ghanshyam',65.550);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `Username` char(10) NOT NULL,
  `Name` text NOT NULL,
  `DOB` text NOT NULL,
  `Gender` text NOT NULL,
  `Number` text NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Password` text NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `userinfo` */

insert  into `userinfo`(`Username`,`Name`,`DOB`,`Gender`,`Number`,`Email`,`Password`) values 
('Prakhar912','Prakhar','27/07/2004','Male','+919302927910','Prakhar@gamil.com','pass2774a@@');

/*Table structure for table `userinfos` */

DROP TABLE IF EXISTS `userinfos`;

CREATE TABLE `userinfos` (
  `username` text,
  `name` text,
  `dob` text,
  `gender` text,
  `phno` text,
  `email` text,
  `password` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `userinfos` */

insert  into `userinfos`(`username`,`name`,`dob`,`gender`,`phno`,`email`,`password`) values 
('hello','hello','2024-12-12','Male','98989898','a@b.c','hello'),
('Prakhar1','Prakhar','0111-11-11','Male','11111111111','adkakfkakf@nsdkln.com','1111111111'),
('Prakhar1','Prakhar','0111-11-11','Male','11111111111','adkakfkakf@nsdkln.com','1111111111'),
('ndfknk','mvmfff','1111-11-11','Female','11111111','11111!@11111','11111'),
('prakhar','mvmfff','0834-08-08','Female','fsgsdf','11111!@11111','34224'),
(NULL,NULL,NULL,'Male','111111111111','manish@ma','abc');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
