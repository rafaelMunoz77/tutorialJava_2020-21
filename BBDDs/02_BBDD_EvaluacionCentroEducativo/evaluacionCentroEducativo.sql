CREATE DATABASE  IF NOT EXISTS `centroeducativo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `centroeducativo`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: centroeducativo
-- ------------------------------------------------------
-- Server version	5.6.16-log

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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'2017-18');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `apellido1` varchar(150) DEFAULT NULL,
  `apellido2` varchar(150) DEFAULT NULL,
  `dni` varchar(15) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `telefono` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Julio','Mármol','Mármol','14785236A','dir, 21','adsf','654785214'),(2,'Francisco','Fernández','Fernández','52874369B','dir, 24','f@f.com','741258963'),(3,'Miguel','Palacios','Fernández','58963214C','dir, 26','m@m.com','632521478');
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `acronimo` varchar(15) DEFAULT NULL,
  `curso_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_asignatura_curso1_idx` (`curso_id`),
  CONSTRAINT `fk_asignatura_curso1` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'Programación','PROG',1),(2,'Lenguajes de Marcas y Sistemas de Gestión de la Información','LMSGI',1),(3,'Sistemas Informáticos','SI',1),(4,'Entornos de Desarrollo','EntDes',1),(5,'Bases de Datos','BD',1),(6,'Formación y Orientación Laboral','FOL',1);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `apellido1` varchar(150) DEFAULT NULL,
  `apellido2` varchar(150) DEFAULT NULL,
  `dni` varchar(15) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `telefono` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Rafael Carlos','López','Ruiz','12345678b','Su casa, 34','asdf','sdaf'),(2,'Joaquín','Molinero','Suárez','23456789B','Su casa también, 42','joaquin@joaquin.com','654789322'),(3,'Miguel Ángel','Pérez','Carmona','98765432C','Otra casa, 12','miguel@miguel.com','654147852'),(4,'Alejandro','Fernández','Fernández','47125896D','Allí, 65','alejandro@alejandro.com','658974125'),(5,'Águeda','Cuenca','Cuenca','96325874','Graná, 25','','698521478');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracionmateria`
--

DROP TABLE IF EXISTS `valoracionmateria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valoracionmateria` (
  `id` int(11) NOT NULL,
  `idProfesor` int(11) NOT NULL,
  `idEstudiante` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `valoracion` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_asignatura_profesor_idx` (`idProfesor`),
  KEY `fk_asignatura_estudiante1_idx` (`idEstudiante`),
  KEY `fk_asignatura_asignatura1_idx` (`idMateria`),
  CONSTRAINT `fk_asignatura_asignatura1` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asignatura_estudiante1` FOREIGN KEY (`idEstudiante`) REFERENCES `estudiante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asignatura_profesor` FOREIGN KEY (`idProfesor`) REFERENCES `profesor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoracionmateria`
--

LOCK TABLES `valoracionmateria` WRITE;
/*!40000 ALTER TABLE `valoracionmateria` DISABLE KEYS */;
INSERT INTO `valoracionmateria` VALUES (1,1,1,1,6),(2,1,1,2,7),(3,2,1,3,6),(4,3,1,4,6),(5,4,1,5,8),(6,5,1,6,4),(7,1,2,1,5),(8,1,2,2,7),(9,2,2,3,8),(10,3,2,4,5),(11,4,2,5,6),(12,5,2,6,4);
/*!40000 ALTER TABLE `valoracionmateria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-09 10:05:53
