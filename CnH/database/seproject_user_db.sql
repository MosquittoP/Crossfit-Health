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
-- Table structure for table `user_db`
--

DROP TABLE IF EXISTS `user_db`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_db` (
  `id` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `name` varchar(10) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `height` float NOT NULL,
  `weight` float NOT NULL,
  `bmi` float GENERATED ALWAYS AS (((`weight` / (`height` * `height`)) * 10000)) STORED,
  `profile` text,
  `calorie` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_db`
--

LOCK TABLES `user_db` WRITE;
/*!40000 ALTER TABLE `user_db` DISABLE KEYS */;
INSERT INTO `user_db` (`id`, `password`, `name`, `age`, `gender`, `height`, `weight`, `profile`, `calorie`) VALUES ('donghan','1234','동한',25,'M',190,80,NULL,500),('jaehun','huniyo','김재훈',25,'M',175,60,NULL,2244),('javajaba','gaza','gaebal',26,'M',210,110,NULL,1351),('junki','dbdb','박준기',26,'M',175,80,NULL,14443),('jym2013','1111','모재영',25,'M',174,65,NULL,800),('nosung','1111','노성균',25,'M',175,78,NULL,195),('sangm','kingy','윤상목',24,'M',175,60,NULL,1555),('sdfs','1234','chun',12,'M',111,111,NULL,0),('sdfsaaaa','1234','chun',12,'M',111,111,NULL,0),('sujin','lee123','이수진',24,'F',163,51,NULL,0),('wer','1234','chun',23,'M',111,11,NULL,-4161),('wodud809','wonder','모재영',25,'M',174,65,NULL,5500),('worhks1','jaekwan','천재관',26,'M',195,100,NULL,19746),('wwww','1234c','cc',111,'F',11,22,NULL,1832);
/*!40000 ALTER TABLE `user_db` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-03 23:30:02
