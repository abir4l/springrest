-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: db_hostel
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_authorities`
--

DROP TABLE IF EXISTS `tbl_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_authorities`
--

LOCK TABLES `tbl_authorities` WRITE;
/*!40000 ALTER TABLE `tbl_authorities` DISABLE KEYS */;
INSERT INTO `tbl_authorities` VALUES (1,'admin'),(2,'admin'),(3,'admin');
/*!40000 ALTER TABLE `tbl_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_bill`
--

DROP TABLE IF EXISTS `tbl_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `english_date` date DEFAULT NULL,
  `invoice_number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_bill_tbl_customers_FK` (`customer_id`),
  CONSTRAINT `tbl_bill_tbl_customers_FK` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bill`
--

LOCK TABLES `tbl_bill` WRITE;
/*!40000 ALTER TABLE `tbl_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_booking`
--

DROP TABLE IF EXISTS `tbl_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `created_on` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_booking_tbl_customers_FK` (`customer_id`),
  CONSTRAINT `tbl_booking_tbl_customers_FK` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_booking`
--

LOCK TABLES `tbl_booking` WRITE;
/*!40000 ALTER TABLE `tbl_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer_itinerary`
--

DROP TABLE IF EXISTS `tbl_customer_itinerary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer_itinerary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `itinerary_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `created_on` date NOT NULL,
  `cleared` tinyint(1) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_customer_service_tbl_customers_FK` (`customer_id`),
  KEY `tbl_customer_service_tbl_services_FK` (`itinerary_id`),
  KEY `tbl_customer_service_tbl_bill_FK` (`bill_id`),
  CONSTRAINT `tbl_customer_itenaries_tbl_itenaries_FK` FOREIGN KEY (`itinerary_id`) REFERENCES `tbl_itenaries` (`id`),
  CONSTRAINT `tbl_customer_service_tbl_bill_FK` FOREIGN KEY (`bill_id`) REFERENCES `tbl_bill` (`id`),
  CONSTRAINT `tbl_customer_service_tbl_customers_FK` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customers` (`id`),
  CONSTRAINT `tbl_customer_service_tbl_services_FK` FOREIGN KEY (`itinerary_id`) REFERENCES `tbl_itenaries` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer_itinerary`
--

LOCK TABLES `tbl_customer_itinerary` WRITE;
/*!40000 ALTER TABLE `tbl_customer_itinerary` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customer_itinerary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer_products`
--

DROP TABLE IF EXISTS `tbl_customer_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `created_on` date DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  `cleared` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_customer_products_tbl_customers_FK` (`customer_id`),
  KEY `tbl_customer_products_tbl_products_FK` (`product_id`),
  KEY `tbl_customer_products_tbl_bill_FK` (`bill_id`),
  CONSTRAINT `tbl_customer_products_tbl_bill_FK` FOREIGN KEY (`bill_id`) REFERENCES `tbl_bill` (`id`),
  CONSTRAINT `tbl_customer_products_tbl_customers_FK` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customers` (`id`),
  CONSTRAINT `tbl_customer_products_tbl_products_FK` FOREIGN KEY (`product_id`) REFERENCES `tbl_products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer_products`
--

LOCK TABLES `tbl_customer_products` WRITE;
/*!40000 ALTER TABLE `tbl_customer_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customer_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customers`
--

DROP TABLE IF EXISTS `tbl_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `passportNumber` varchar(100) NOT NULL,
  `nation` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `parentId` int(1) DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_customers_parent_id_IDX` (`parentId`),
  CONSTRAINT `tbl_customers_tbl_customers_FK` FOREIGN KEY (`parentId`) REFERENCES `tbl_customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customers`
--

LOCK TABLES `tbl_customers` WRITE;
/*!40000 ALTER TABLE `tbl_customers` DISABLE KEYS */;
INSERT INTO `tbl_customers` VALUES (1,'sandhya Nepal','sandhya@nasd.com','asdasdgg45','Nepali',NULL,0,3,NULL,NULL),(3,'Abiral Khanal','abiralkhanal@outlook.com','5454as','Nepali','654654',0,NULL,'2017-05-01 16:58:23',NULL),(4,'Sandhya Nepal','sandhya@nasd.com','asdasdgg45','Nepali',NULL,0,3,'2017-05-01 17:13:49',NULL);
/*!40000 ALTER TABLE `tbl_customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_itenaries`
--

DROP TABLE IF EXISTS `tbl_itenaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_itenaries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `modified_on` date DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_itenaries`
--

LOCK TABLES `tbl_itenaries` WRITE;
/*!40000 ALTER TABLE `tbl_itenaries` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_itenaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_products`
--

DROP TABLE IF EXISTS `tbl_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `price` double(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sold` int(11) DEFAULT '0',
  `remarks` varchar(100) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `modified_on` date DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_products`
--

LOCK TABLES `tbl_products` WRITE;
/*!40000 ALTER TABLE `tbl_products` DISABLE KEYS */;
INSERT INTO `tbl_products` VALUES (1,'waiwai',25.00,250,0,NULL,NULL,NULL,0),(11,'waiwai',25.00,250,0,'Some Remarks',NULL,NULL,0);
/*!40000 ALTER TABLE `tbl_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_stock`
--

DROP TABLE IF EXISTS `tbl_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `initial_stock` int(11) DEFAULT NULL,
  `final_stock` int(11) DEFAULT NULL,
  `spent_quantity` int(11) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks` varchar(100) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `modified_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_stock_tbl_products_FK` (`product_id`),
  CONSTRAINT `tbl_stock_tbl_products_FK` FOREIGN KEY (`product_id`) REFERENCES `tbl_products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_stock`
--

LOCK TABLES `tbl_stock` WRITE;
/*!40000 ALTER TABLE `tbl_stock` DISABLE KEYS */;
INSERT INTO `tbl_stock` VALUES (1,11,250,250,0,'2017-05-01 04:39:58','Product Added',0,NULL);
/*!40000 ALTER TABLE `tbl_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_transaction_customer`
--

DROP TABLE IF EXISTS `tbl_transaction_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_transaction_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double(10,2) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `created_on` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_transaction_customer_tbl_customers_FK` (`customer_id`),
  CONSTRAINT `tbl_transaction_customer_tbl_customers_FK` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_transaction_customer`
--

LOCK TABLES `tbl_transaction_customer` WRITE;
/*!40000 ALTER TABLE `tbl_transaction_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_transaction_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `authority_id` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `tbl_users_tbl_authorities_FK` (`authority_id`),
  CONSTRAINT `tbl_users_tbl_authorities_FK` FOREIGN KEY (`authority_id`) REFERENCES `tbl_authorities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES (1,'Abiral Khanal','abiralkhanal@outlook.com','password','9801182564',1,0),(3,'Sandhya Nepal','sandhyan070@gmail.com','password','9801182564',1,0);
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_hostel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-15 22:10:53
