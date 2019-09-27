# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Hôte: 127.0.0.1 (MySQL 5.5.5-10.3.15-MariaDB-1:10.3.15+maria~bionic)
# Base de données: bibliotheque
# Temps de génération: 2019-09-27 14:08:19 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Affichage de la table Admin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Admin`;

CREATE TABLE `Admin` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;

INSERT INTO `Admin` (`id`, `login`, `pass`)
VALUES
	(1,'admin','admin');

/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table hibernate_sequence
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;

INSERT INTO `hibernate_sequence` (`next_val`)
VALUES
	(17);

/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


# Affichage de la table Livre
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Livre`;

CREATE TABLE `Livre` (
  `id` int(11) NOT NULL,
  `annee` int(11) DEFAULT NULL,
  `auteur` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Affichage de la table Utilisateur
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Utilisateur`;

CREATE TABLE `Utilisateur` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Utilisateur` WRITE;
/*!40000 ALTER TABLE `Utilisateur` DISABLE KEYS */;

INSERT INTO `Utilisateur` (`id`, `login`, `pass`)
VALUES
	(2,'raphael','raphael');

/*!40000 ALTER TABLE `Utilisateur` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
