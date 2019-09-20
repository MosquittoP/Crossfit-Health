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
-- Table structure for table `exercise_db`
--

DROP TABLE IF EXISTS `exercise_db`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exercise_db` (
  `title` varchar(20) NOT NULL,
  `description` varchar(45) NOT NULL,
  `youtubeurl` text,
  `calorie` float NOT NULL,
  `pic` text,
  `part` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`part`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_db`
--

LOCK TABLES `exercise_db` WRITE;
/*!40000 ALTER TABLE `exercise_db` DISABLE KEYS */;
INSERT INTO `exercise_db` VALUES ('내로우푸쉬업','내로우',NULL,700,'arm1',1,1),('딥스','딥스',NULL,600,'arm2',1,2),('원암트라이셉스푸쉬업','한팔로',NULL,500,'arm3',1,3),('다이아몬드푸쉬업','다이아몬드로',NULL,500,'arm4',1,4),('할로우','하알로우',NULL,800,'arm5',1,5),('슈퍼맨푸쉬업','슈퍼맨',NULL,900,'arm6',1,6),('사이드플랭크 푸쉬업','몸을 일자로 하는 것이 중요','yotube.com',273,'arm7',1,7),('브릿지','다리처럼',NULL,800,'leg1',2,1),('v싯업','v자로하기',NULL,400,'body1',2,2),('리버스크런치','거꾸로해보자',NULL,500,'body2',2,3),('버티컬레그레이즈','버티컬로하자',NULL,450,'body3',2,4),('시티드싯업','앉아서 해버리자',NULL,650,'body4',2,5),('슈퍼맨','허리를 최대한 수축',NULL,500,'body5',2,6),('복근/골반운동','다리를 직각으로 올리기',NULL,400,'body6',2,7),('투명의자','꼼수부리지 않기','youtube.com',573,'wallsit',3,1),('원레그스쿼트','다리하나로',NULL,600,'leg2',3,2),('원레크브릿지','다리하나로 다리처럼',NULL,800,'leg3',3,3),('월싯','벽에다가',NULL,750,'leg4',3,4),('보디웨이트레그컬','조심히하자',NULL,630,'leg5',3,5),('점프스쿼트','점프',NULL,1200,'leg6',3,6),('서포트원레그스쿼트','잘 기대자',NULL,400,'leg7',3,7);
/*!40000 ALTER TABLE `exercise_db` ENABLE KEYS */;
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
