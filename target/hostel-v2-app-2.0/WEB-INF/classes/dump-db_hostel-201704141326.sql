-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: db_hostel
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_authorities`
--

LOCK TABLES `tbl_authorities` WRITE;
/*!40000 ALTER TABLE `tbl_authorities` DISABLE KEYS */;
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
-- Table structure for table `tbl_customer_service`
--

DROP TABLE IF EXISTS `tbl_customer_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `services_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `created_on` date NOT NULL,
  `cleared` tinyint(1) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_customer_service_tbl_customers_FK` (`customer_id`),
  KEY `tbl_customer_service_tbl_services_FK` (`services_id`),
  KEY `tbl_customer_service_tbl_bill_FK` (`bill_id`),
  CONSTRAINT `tbl_customer_service_tbl_bill_FK` FOREIGN KEY (`bill_id`) REFERENCES `tbl_bill` (`id`),
  CONSTRAINT `tbl_customer_service_tbl_customers_FK` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customers` (`id`),
  CONSTRAINT `tbl_customer_service_tbl_services_FK` FOREIGN KEY (`services_id`) REFERENCES `tbl_services` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer_service`
--

LOCK TABLES `tbl_customer_service` WRITE;
/*!40000 ALTER TABLE `tbl_customer_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customer_service` ENABLE KEYS */;
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
  `passport_number` varchar(100) NOT NULL,
  `nation` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customers`
--

LOCK TABLES `tbl_customers` WRITE;
/*!40000 ALTER TABLE `tbl_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customers` ENABLE KEYS */;
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
  `remarks` varchar(100) DEFAULT NULL,
  `create_on` date DEFAULT NULL,
  `modified_on` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_products`
--

LOCK TABLES `tbl_products` WRITE;
/*!40000 ALTER TABLE `tbl_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_services`
--

DROP TABLE IF EXISTS `tbl_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `modified_on` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_services`
--

LOCK TABLES `tbl_services` WRITE;
/*!40000 ALTER TABLE `tbl_services` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_services` ENABLE KEYS */;
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
  `stock_quantity` int(11) DEFAULT NULL,
  `spend_quanity` int(11) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_stock_tbl_products_FK` (`product_id`),
  CONSTRAINT `tbl_stock_tbl_products_FK` FOREIGN KEY (`product_id`) REFERENCES `tbl_products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_stock`
--

LOCK TABLES `tbl_stock` WRITE;
/*!40000 ALTER TABLE `tbl_stock` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `tbl_users_tbl_authorities_FK` (`authority_id`),
  CONSTRAINT `tbl_users_tbl_authorities_FK` FOREIGN KEY (`authority_id`) REFERENCES `tbl_authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
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

-- Dump completed on 2017-04-14 13:26:12
