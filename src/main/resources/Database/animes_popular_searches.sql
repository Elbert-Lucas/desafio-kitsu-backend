CREATE DATABASE  IF NOT EXISTS `animes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `animes`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: animes
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `popular_searches`
--

DROP TABLE IF EXISTS `popular_searches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `popular_searches` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent` varchar(255) NOT NULL,
  `search_count` bigint NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popular_searches`
--

LOCK TABLES `popular_searches` WRITE;
/*!40000 ALTER TABLE `popular_searches` DISABLE KEYS */;
INSERT INTO `popular_searches` VALUES (1,'cowboy-bebop','cowboy-bebop',2,'Anime'),(2,'cowboy-bebop-tengoku-no-tobira','cowboy-bebop-tengoku-no-tobira',3,'Anime'),(6,'eyeshield-21','eyeshield-21',1,'Anime'),(11,'naruto','naruto',2,'Anime'),(12,'one-piece','one-piece',4,'Anime'),(25,'koisuru-vector','koisuru-vector',2,'Manga'),(62,'ranma','ranma',1,'Manga'),(123,'kareshi-kanojo-no-jijou','kareshi-kanojo-no-jijou',1,'Anime'),(132,'love-cubic','love-cubic',1,'Manga'),(152,'tokyo-underground','tokyo-underground',1,'Anime'),(245,'hellsing','hellsing',1,'Anime'),(248,'mahou-tsukai-ni-taisetsu-na-koto','mahou-tsukai-ni-taisetsu-na-koto',1,'Anime'),(1323,'null','woodman-dyeon',1,'Chapter'),(1391,'attack-no-1','attack-no-1',1,'Anime'),(1559,'disgaea-2','disgaea-2',1,'Manga'),(2567,'ahiru-no-quack','ahiru-no-quack',1,'Anime'),(2847,'guitar-wo-motta-shounen-kikaider-vs-inazuman','guitar-wo-motta-shounen-kikaider-vs-inazuman',1,'Anime'),(3725,'toaru-majutsu-no-index','toaru-majutsu-no-index',1,'Anime'),(4478,'toaru-kagaku-no-railgun','toaru-kagaku-no-railgun',1,'Anime'),(4560,'saiyuki-reload-urasai','saiyuki-reload-urasai',1,'Anime'),(4595,'porong-porong-pororo','porong-porong-pororo',1,'Anime'),(4849,'crush-gear-nitro','crush-gear-nitro',1,'Anime'),(5507,'kore-wa-zombie-desu-ka','kore-wa-zombie-desu-ka',1,'Anime'),(5861,'a-channel','a-channel',1,'Anime'),(6325,'a-channel-a-channel','a-channel-a-channel',1,'Anime'),(6745,'the-ring-2','the-ring-2',1,'Manga'),(9097,'spheres','spheres',1,'Anime'),(9135,'tokyo-ghoul-2','tokyo-ghoul-2',1,'Anime'),(9317,'hidamari-no-ie','hidamari-no-ie',1,'Anime'),(9372,'kaze-no-tabibito','kaze-no-tabibito',1,'Anime'),(10028,'koe-no-katachi','koe-no-katachi',1,'Anime'),(10372,'uks-uks','uks-uks',1,'Anime'),(10740,'one-punch-man','one-punch-man',1,'Anime'),(12939,'detective-conan-city-exploration-get-the-animal-mark','detective-conan-city-exploration-get-the-animal-mark',1,'Anime'),(17159,'1-2-prince','1-2-prince',1,'Manga'),(24657,'1-2-prince-novel','1-2-prince-novel',1,'Manga'),(36596,'douluo-dalu-ii-jueshi-tangmen','douluo-dalu-ii-jueshi-tangmen',1,'Manga'),(37280,'kimetsu-no-yaiba','kimetsu-no-yaiba',1,'Manga'),(40702,'tottoko-hamtarou-no-tottoko-daijida-bousai-kunren','tottoko-hamtarou-no-tottoko-daijida-bousai-kunren',1,'Anime'),(41980,'toaru-kagaku-no-accelerator','toaru-kagaku-no-accelerator',1,'Anime'),(49598,'cheese-in-the-trap-season-2','cheese-in-the-trap-season-2',1,'Manga'),(55427,'dokgo-2','dokgo-2',1,'Manga'),(57929,'panlong2','panlong2',1,'Manga'),(59059,'four-way-stop','four-way-stop',1,'Manga'),(103482,'I\'m Luffy! The Man Who\'s Gonna Be King of the Pirates!','one-piece',1,'Episode'),(401759,'Romance Dawn','one-piece',1,'Chapter');
/*!40000 ALTER TABLE `popular_searches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-08 18:32:28
