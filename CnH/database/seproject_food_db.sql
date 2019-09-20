-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 192.168.25.5    Database: seproject
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `food_db`
--

DROP TABLE IF EXISTS `food_db`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food_db` (
  `title` varchar(20) NOT NULL,
  `description` varchar(45) NOT NULL,
  `youtubeurl` text,
  `calorie` float NOT NULL,
  `pic` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_db`
--

LOCK TABLES `food_db` WRITE;
/*!40000 ALTER TABLE `food_db` DISABLE KEYS */;
INSERT INTO `food_db` VALUES ('치킨','치킨맛있다','y',1300,'f1',1,1),('피자','이탈리음식','y',800,'f2',2,1),('곱창','안지랑음식','y',700,'f3',3,1),('국밥','운수좋은날','y',1100,'f4',4,1),('꼬치','언제든지','y',300,'f5',5,1),('돈까스','경양식','y',800,'f6',6,1),('만두','중국음식','y',300,'f7',7,1),('삼겹살','삼겹살엔 소...','y',1200,'f8',8,1),('새우튀김','덴뿌라','y',200,'f9',9,1),('족발','야무지게','y',800,'f10',10,1),('케익','달달한 케익','y',700,'f11',11,1);
/*!40000 ALTER TABLE `food_db` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-03 23:30:03
