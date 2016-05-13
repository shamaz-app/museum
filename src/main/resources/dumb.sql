CREATE DATABASE  IF NOT EXISTS `museum` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `museum`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: museum
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `id_country` int(11) NOT NULL,
  `id_city_type` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FC_CITY_COUNTRY_idx` (`id_country`),
  KEY `FC_CITY_CITY_TYPE_idx` (`id_city_type`),
  CONSTRAINT `FC_CITY_CITY_TYPE` FOREIGN KEY (`id_city_type`) REFERENCES `city_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_CITY_COUNTRY` FOREIGN KEY (`id_country`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,1,1,'Минск'),(2,1,1,'Брест');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_type`
--

DROP TABLE IF EXISTS `city_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `abbrev` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_type`
--

LOCK TABLES `city_type` WRITE;
/*!40000 ALTER TABLE `city_type` DISABLE KEYS */;
INSERT INTO `city_type` VALUES (1,'город','г.'),(2,'область','обл.');
/*!40000 ALTER TABLE `city_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `id_contact_type` int(11) NOT NULL,
  `contact` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FC_CONTACT_CT_idx` (`id_contact_type`),
  CONSTRAINT `FC_CONTACT_CT` FOREIGN KEY (`id_contact_type`) REFERENCES `contact_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,1,'(29)777-77-77');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_type`
--

DROP TABLE IF EXISTS `contact_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_type`
--

LOCK TABLES `contact_type` WRITE;
/*!40000 ALTER TABLE `contact_type` DISABLE KEYS */;
INSERT INTO `contact_type` VALUES (1,'тел'),(2,'e-mail');
/*!40000 ALTER TABLE `contact_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `abbrev` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Республика Беларусь','РБ'),(2,'Россия','Рос.');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museum_build`
--

DROP TABLE IF EXISTS `museum_build`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `museum_build` (
  `id` int(11) NOT NULL,
  `id_street` int(11) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `house_number` varchar(45) NOT NULL,
  `count_showpiece` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FC_MUSEUM_STREET_idx` (`id_street`),
  CONSTRAINT `FC_MUSEUM_STREET` FOREIGN KEY (`id_street`) REFERENCES `street` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museum_build`
--

LOCK TABLES `museum_build` WRITE;
/*!40000 ALTER TABLE `museum_build` DISABLE KEYS */;
INSERT INTO `museum_build` VALUES (1,1,'Картинная галерея','75',20);
/*!40000 ALTER TABLE `museum_build` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museum_contact`
--

DROP TABLE IF EXISTS `museum_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `museum_contact` (
  `id_museum` int(11) NOT NULL,
  `id_contact` int(11) NOT NULL,
  PRIMARY KEY (`id_museum`,`id_contact`),
  KEY `FC_MUSEUM_CONTACT_C_idx` (`id_contact`),
  CONSTRAINT `FC_MC_M` FOREIGN KEY (`id_museum`) REFERENCES `museum_build` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_MUSEUM_CONTACT_C` FOREIGN KEY (`id_contact`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museum_contact`
--

LOCK TABLES `museum_contact` WRITE;
/*!40000 ALTER TABLE `museum_contact` DISABLE KEYS */;
INSERT INTO `museum_contact` VALUES (1,1);
/*!40000 ALTER TABLE `museum_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `origin_source`
--

DROP TABLE IF EXISTS `origin_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `origin_source` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `abbrev` varchar(45) DEFAULT '',
  `note` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origin_source`
--

LOCK TABLES `origin_source` WRITE;
/*!40000 ALTER TABLE `origin_source` DISABLE KEYS */;
INSERT INTO `origin_source` VALUES (1,'Искусство','',''),(2,'Археология','',''),(3,'Артефакт','','');
/*!40000 ALTER TABLE `origin_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showpiece`
--

DROP TABLE IF EXISTS `showpiece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showpiece` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT '',
  `NOTE` varchar(225) DEFAULT '',
  `NUMBER_OF_COPIES` varchar(10) DEFAULT '',
  `ID_SOURCE` int(11) NOT NULL,
  `ID_THEMATIC_SECTION` int(11) NOT NULL,
  `AGE` varchar(45) DEFAULT NULL,
  `ID_STATE` int(11) DEFAULT NULL,
  `ID_MUSEUM` int(11) DEFAULT '1',
  `IMAGE_URL` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FC_SOURCE_OS_idx` (`ID_SOURCE`),
  KEY `FC_THEME_idx` (`ID_THEMATIC_SECTION`),
  KEY `FC_STATE_idx` (`ID_STATE`),
  KEY `FC_SHOWPIECE_MUSEUM_idx` (`ID_MUSEUM`),
  CONSTRAINT `FC_MUSEUM_BUILD` FOREIGN KEY (`ID_MUSEUM`) REFERENCES `museum_build` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_SOURCE_OS` FOREIGN KEY (`ID_SOURCE`) REFERENCES `origin_source` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_STATE` FOREIGN KEY (`ID_STATE`) REFERENCES `state` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_THEME` FOREIGN KEY (`ID_THEMATIC_SECTION`) REFERENCES `thematic_section` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showpiece`
--

LOCK TABLES `showpiece` WRITE;
/*!40000 ALTER TABLE `showpiece` DISABLE KEYS */;
INSERT INTO `showpiece` VALUES (1,'Первый трактор МТЗ','','1',1,3,'55',1,1,'https://docs.google.com/uc?id=0B7aQThvXd024LWJXQzdiY0xLbGM&export=download'),(2,'Картина сальвадора дали','Три медведя','1',2,2,'200',2,1,'https://docs.google.com/uc?id=0B7aQThvXd024WmdyOVNPdFdJQ28&export=download'),(3,'Второй трактор МТЗ','','1',1,3,'54',1,1,NULL),(4,'Третий трактор МТЗ','','1',1,3,'54',1,1,NULL),(5,'Первый бульдозер АМКАДОРа','','1',1,4,'35',1,1,NULL),(7,'Портянка ивана баланара','Он в ней потел на TI 1',NULL,1,2,NULL,4,1,NULL),(10,'пашины дырявые джинсы','фывфыв',NULL,1,4,NULL,7,1,NULL),(19,'Первый морской узел','гагаг',NULL,1,1,NULL,16,1,NULL),(20,'фывфв','фыф',NULL,1,1,NULL,17,1,NULL),(21,'фывфв','фыф',NULL,1,1,NULL,18,1,NULL),(22,'фывфв','фыф',NULL,1,1,NULL,19,1,NULL),(23,'Клевый курсач','Самый лууучший',NULL,2,3,NULL,20,1,'https://docs.google.com/uc?id=0B7aQThvXd024MnVfUE83S1g0c00&export=download');
/*!40000 ALTER TABLE `showpiece` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `museum`.`showpiece_AFTER_INSERT` AFTER INSERT ON `showpiece` FOR EACH ROW
BEGIN
	update museum_build 
    set count_showpiece = count_showpiece + 1 
    where id = NEW.id_museum;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `showroom`
--

DROP TABLE IF EXISTS `showroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showroom` (
  `ID` int(11) NOT NULL,
  `SHOWROOM_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showroom`
--

LOCK TABLES `showroom` WRITE;
/*!40000 ALTER TABLE `showroom` DISABLE KEYS */;
INSERT INTO `showroom` VALUES (1,'1'),(2,'2');
/*!40000 ALTER TABLE `showroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showroom_content`
--

DROP TABLE IF EXISTS `showroom_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showroom_content` (
  `ID_SHOWROOM` int(11) NOT NULL,
  `ID_SHOWPIECE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SHOWROOM`,`ID_SHOWPIECE`),
  KEY `FC_SHOWPIECE_CONTENT_idx` (`ID_SHOWPIECE`),
  CONSTRAINT `FC_ROOM_CONTENT` FOREIGN KEY (`ID_SHOWROOM`) REFERENCES `showroom` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_SHOWPIECE_CONTENT` FOREIGN KEY (`ID_SHOWPIECE`) REFERENCES `showpiece` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showroom_content`
--

LOCK TABLES `showroom_content` WRITE;
/*!40000 ALTER TABLE `showroom_content` DISABLE KEYS */;
INSERT INTO `showroom_content` VALUES (1,1);
/*!40000 ALTER TABLE `showroom_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showroom_thematic_section`
--

DROP TABLE IF EXISTS `showroom_thematic_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showroom_thematic_section` (
  `ID_SHOWROOM` int(11) NOT NULL,
  `ID_THEME_SECTION` int(11) NOT NULL,
  PRIMARY KEY (`ID_SHOWROOM`,`ID_THEME_SECTION`),
  KEY `FC_THEME_SECTION_idx` (`ID_THEME_SECTION`),
  CONSTRAINT `FC_SHOWROOM` FOREIGN KEY (`ID_SHOWROOM`) REFERENCES `showroom` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_THEME_SECTION` FOREIGN KEY (`ID_THEME_SECTION`) REFERENCES `thematic_section` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showroom_thematic_section`
--

LOCK TABLES `showroom_thematic_section` WRITE;
/*!40000 ALTER TABLE `showroom_thematic_section` DISABLE KEYS */;
INSERT INTO `showroom_thematic_section` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `showroom_thematic_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `ID` int(11) NOT NULL,
  `ID_STATE_TYPE` int(11) NOT NULL,
  `DESCRIPTION` varchar(225) DEFAULT NULL,
  `IS_NEED_RESTORATION` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FC_STATE_ST_idx` (`ID_STATE_TYPE`),
  CONSTRAINT `FC_STATE_ST` FOREIGN KEY (`ID_STATE_TYPE`) REFERENCES `state_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,1,'После производства первого трактора он был размещен на проходной',0),(2,1,'aaa',1),(4,2,'Дырка с монету на левом колене',NULL),(7,2,'Дырка справа',1),(16,1,'Как-будто сегодня связали',1),(17,1,'фывфвы',1),(18,1,'фывфвы',1),(19,1,'фывфвы',1),(20,1,'фывфыв',1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_type`
--

DROP TABLE IF EXISTS `state_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_type` (
  `ID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_type`
--

LOCK TABLES `state_type` WRITE;
/*!40000 ALTER TABLE `state_type` DISABLE KEYS */;
INSERT INTO `state_type` VALUES (1,'Превосходное'),(2,'Немного поношенное'),(3,'Прямо с завода');
/*!40000 ALTER TABLE `state_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `id` int(11) NOT NULL,
  `id_city` int(11) NOT NULL,
  `id_street_type` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FC_STREET_CITY_idx` (`id_city`),
  KEY `FC_STREET_STREET_TYPE_idx` (`id_street_type`),
  CONSTRAINT `FC_STREET_CITY` FOREIGN KEY (`id_city`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FC_STREET_STREET_TYPE` FOREIGN KEY (`id_street_type`) REFERENCES `street_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,1,3,'Независимости');
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street_type`
--

DROP TABLE IF EXISTS `street_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `abbrev` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street_type`
--

LOCK TABLES `street_type` WRITE;
/*!40000 ALTER TABLE `street_type` DISABLE KEYS */;
INSERT INTO `street_type` VALUES (1,'улица','ул.'),(2,'переулок','пер.'),(3,'проспект','пр.');
/*!40000 ALTER TABLE `street_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thematic_section`
--

DROP TABLE IF EXISTS `thematic_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thematic_section` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(225) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thematic_section`
--

LOCK TABLES `thematic_section` WRITE;
/*!40000 ALTER TABLE `thematic_section` DISABLE KEYS */;
INSERT INTO `thematic_section` VALUES (1,'Картины'),(2,'Археологические находки до 10 тыс. лет до н.э.'),(3,'Сельскохозяйственная техника'),(4,'Строительная техника');
/*!40000 ALTER TABLE `thematic_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'museum'
--

--
-- Dumping routines for database 'museum'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-13 11:43:30
