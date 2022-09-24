-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gocheeta
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accessibility_vehicles_tbl`
--

DROP TABLE IF EXISTS `accessibility_vehicles_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessibility_vehicles_tbl` (
  `PK_DriverID` int NOT NULL,
  `PK_NumberPlate` varchar(45) NOT NULL,
  `VehicleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PK_NumberPlate`,`PK_DriverID`),
  KEY `NumberPlate_idx` (`PK_NumberPlate`),
  KEY `FK_DriverID` (`PK_DriverID`),
  CONSTRAINT `FK_DriverID` FOREIGN KEY (`PK_DriverID`) REFERENCES `driver_tbl` (`PK_DriverID`),
  CONSTRAINT `FK_NumberPlate` FOREIGN KEY (`PK_NumberPlate`) REFERENCES `vehicle_tbl` (`PK_NumberPlate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessibility_vehicles_tbl`
--

LOCK TABLES `accessibility_vehicles_tbl` WRITE;
/*!40000 ALTER TABLE `accessibility_vehicles_tbl` DISABLE KEYS */;
INSERT INTO `accessibility_vehicles_tbl` VALUES (5,'GG-2222','test2car3'),(6,'GG-2222','test2car'),(7,'GG-2222','test2car'),(7,'GG-3333','test3');
/*!40000 ALTER TABLE `accessibility_vehicles_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_tbl`
--

DROP TABLE IF EXISTS `admin_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_tbl` (
  `PK_AdminID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `PhoneNumber` varchar(15) NOT NULL,
  `Address` varchar(90) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `AccType` varchar(45) NOT NULL,
  `BranchID` int DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`PK_AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_tbl`
--

LOCK TABLES `admin_tbl` WRITE;
/*!40000 ALTER TABLE `admin_tbl` DISABLE KEYS */;
INSERT INTO `admin_tbl` VALUES (1,'test1','test@gmail.com','08787809','testrd','2022-08-09','MainAdmin',NULL,'Male','test1','fFUgLBht%T'),(2,'test2','test2@gmail.com','087878','testrd2','2022-08-21','BranchAdmin',2,'Male','test2','0cpQC9h#3');
/*!40000 ALTER TABLE `admin_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_tbl`
--

DROP TABLE IF EXISTS `booking_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_tbl` (
  `PK_BookingID` int NOT NULL AUTO_INCREMENT,
  `CreatedDate` datetime DEFAULT NULL,
  `BookingTime` datetime DEFAULT NULL,
  `CustormerID` int DEFAULT NULL,
  `DriverID` int DEFAULT NULL,
  `VehicleID` varchar(45) DEFAULT NULL,
  `CustormerName` varchar(45) DEFAULT NULL,
  `sourceLocation` varchar(45) DEFAULT NULL,
  `Destination` varchar(45) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Distance` decimal(10,2) DEFAULT NULL,
  `Rate` int DEFAULT NULL,
  `RateMsg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PK_BookingID`),
  KEY `CustormerID_idx` (`CustormerID`),
  CONSTRAINT `CustormerID` FOREIGN KEY (`CustormerID`) REFERENCES `customer-tbl` (`PK_CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_tbl`
--

LOCK TABLES `booking_tbl` WRITE;
/*!40000 ALTER TABLE `booking_tbl` DISABLE KEYS */;
INSERT INTO `booking_tbl` VALUES (1,'2022-09-19 19:44:42','2022-09-28 21:44:00',1,5,'GG-2222','Test1','test1s','test1d',210.00,'Complete',3.00,4,'good okay'),(4,'2022-09-24 01:10:12','2022-10-05 04:10:00',1,5,'GG-2222','Test1','test1s','test1d',210.00,'ongoing',3.00,NULL,NULL);
/*!40000 ALTER TABLE `booking_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch_tbl`
--

DROP TABLE IF EXISTS `branch_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch_tbl` (
  `PK_BranchID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `PhoneNumber` varchar(15) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `City` varchar(45) NOT NULL,
  `Latitude` double NOT NULL,
  `Longitude` double NOT NULL,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`PK_BranchID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch_tbl`
--

LOCK TABLES `branch_tbl` WRITE;
/*!40000 ALTER TABLE `branch_tbl` DISABLE KEYS */;
INSERT INTO `branch_tbl` VALUES (1,'GoCheeta - Nugegoda','0122233699','test address road','Nugegoda',-54.5454365,20,0),(2,'GoCheeta - Maharagama','0112223337','test address 2 ','Maharagama',-71,10.543,1),(5,'GoCheeta - Maharagama2','0112223333','test address 2 ','Maharagama2',-70.6565,10.4554,1);
/*!40000 ALTER TABLE `branch_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer-tbl`
--

DROP TABLE IF EXISTS `customer-tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer-tbl` (
  `PK_CustomerID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PK_CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-tbl`
--

LOCK TABLES `customer-tbl` WRITE;
/*!40000 ALTER TABLE `customer-tbl` DISABLE KEYS */;
INSERT INTO `customer-tbl` VALUES (1,'Test1','test address','+94768527431','Male','test1@gmail.com','test1234'),(2,'Test1','test address','+94768527432','Male','test1@gmail.com','test1234'),(3,'Test1','test address','+94768527433','Male','test1@gmail.com','test1234');
/*!40000 ALTER TABLE `customer-tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_tbl`
--

DROP TABLE IF EXISTS `driver_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_tbl` (
  `PK_DriverID` int NOT NULL AUTO_INCREMENT,
  `ImageLocation` varchar(225) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `BranchID` varchar(45) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PK_DriverID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_tbl`
--

LOCK TABLES `driver_tbl` WRITE;
/*!40000 ALTER TABLE `driver_tbl` DISABLE KEYS */;
INSERT INTO `driver_tbl` VALUES (5,'ServerFiles/Drivers/1663362720128.png','test 4','test1@gmail.lk','0112223333','test rd','2022-08-09','2','Male','test1','test12345','onRide'),(6,'ServerFiles/Drivers/1663424945076.png','test5','test5@gmail.com','0112223333','test rd','2022-05-31','1','Male','test5','P4knMM7gwg','Available'),(7,'ServerFiles/Drivers/1663426512231.png','test6','test6@gmail.com','0112223333','test rd','2022-06-27','1','Male','test6','u&h65YaTF','onRide');
/*!40000 ALTER TABLE `driver_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_tbl`
--

DROP TABLE IF EXISTS `location_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_tbl` (
  `PK_LocationID` int NOT NULL AUTO_INCREMENT,
  `BranchID` int NOT NULL,
  `Source` varchar(255) NOT NULL,
  `Destination` varchar(255) NOT NULL,
  `Distance` decimal(10,2) NOT NULL,
  PRIMARY KEY (`PK_LocationID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_tbl`
--

LOCK TABLES `location_tbl` WRITE;
/*!40000 ALTER TABLE `location_tbl` DISABLE KEYS */;
INSERT INTO `location_tbl` VALUES (1,1,'test1s','test1d',3.00),(2,2,'test2s','test2d',14.00),(3,1,'test3s','test3d',16.00),(4,2,'test4s','test4d',4.00),(5,1,'test1s','test3d',8.00);
/*!40000 ALTER TABLE `location_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_tbl`
--

DROP TABLE IF EXISTS `vehicle_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_tbl` (
  `PK_NumberPlate` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `ImagePath` varchar(45) DEFAULT NULL,
  `Seat` int DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `BranchID` int DEFAULT NULL,
  `CategoryID` int DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `BaseFare` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`PK_NumberPlate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_tbl`
--

LOCK TABLES `vehicle_tbl` WRITE;
/*!40000 ALTER TABLE `vehicle_tbl` DISABLE KEYS */;
INSERT INTO `vehicle_tbl` VALUES ('GG-2222','test2car3','ServerFiles/Vehicle/1663427142510.png',4,'black',1,9,'onRide',70.00),('GG-3333','test3','ServerFiles/Vehicle/1663450461540.png',8,'Blue',1,9,'onRide',80.60);
/*!40000 ALTER TABLE `vehicle_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiclecategory_tbl`
--

DROP TABLE IF EXISTS `vehiclecategory_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiclecategory_tbl` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `ImageFileLocation` varchar(255) DEFAULT NULL,
  `CategoryName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiclecategory_tbl`
--

LOCK TABLES `vehiclecategory_tbl` WRITE;
/*!40000 ALTER TABLE `vehiclecategory_tbl` DISABLE KEYS */;
INSERT INTO `vehiclecategory_tbl` VALUES (9,'ServerFiles/VehicleCategory/1663341710405.png','test11'),(10,'ServerFiles/VehicleCategory/1663339958629.png','test14'),(11,'ServerFiles/VehicleCategory/1663516355369.jpeg','test 15');
/*!40000 ALTER TABLE `vehiclecategory_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-24 23:33:54
