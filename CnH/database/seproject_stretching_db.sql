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
-- Table structure for table `stretching_db`
--

DROP TABLE IF EXISTS `stretching_db`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stretching_db` (
  `title` varchar(20) NOT NULL,
  `description` varchar(45) NOT NULL,
  `youtubeurl` text,
  `calorie` float NOT NULL,
  `pic` text,
  `part` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`part`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stretching_db`
--

LOCK TABLES `stretching_db` WRITE;
/*!40000 ALTER TABLE `stretching_db` DISABLE KEYS */;
INSERT INTO `stretching_db` VALUES ('팔안쪽 스트레칭','시원하다','y',60,'sarm1',1,1),('기모으는 스트레칭','조심히','y',80,'sb7',2,1),('누워서다리당기는 스트레칭','다리당기기','y',90,'sleg1',3,1),('팔뻣기 스트레칭','하늘에 닿도록','y',90,'sarm2',1,2),('누워서 가슴스트레칭','사체아닙니다','y',100,'sb1',2,2),('누워서다리들어주는스트레칭','들어주다',NULL,70,'sleg2',3,2),('팔과어깨 스트레칭','어깨괜찮아','y',80,'sarm3',1,3),('삼두와 가슴스트레칭','동시에','y',80,'sb2',2,3),('누워서발당기는 스트레칭','발당기기',NULL,65,'sleg3',3,3),('팔과 등 위쪽 스트레칭','고생했어','y',75,'sarm4',1,4),('서서하는 가슴스트레칭','모두 일어서','y',60,'sb3',2,4),('다리를벽에기대는스트레칭','벽에 기대요',NULL,20,'sleg4',3,4),('삼두근스트레칭','삼두를 쭉쭉','y',60,'sarm5',1,5),('승천스트레칭','하늘로 가즈아','y',60,'sb4',2,5),('다리를접는스트레칭','과하지 않게',NULL,40,'sleg5',3,5),('삼두와가슴스트레칭','동시에','y',80,'sarm6',1,6),('팔과가슴스트레칭','시원하게','y',80,'sb5',2,6),('서서몸구부리는스트레칭','구부리자',NULL,30,'sleg6',3,6),('팔과가슴스트레칭','시원하게','y',60,'sarm7',1,7),('하늘보는스트레칭','하늘을 봅시다','y',90,'sb6',2,7),('앉아서 몸 구부리는 스트레칭','이번엔 앉아서',NULL,70,'sleg7',3,7);
/*!40000 ALTER TABLE `stretching_db` ENABLE KEYS */;
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
