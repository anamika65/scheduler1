-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 09. Apr 2013 um 17:04
-- Server Version: 5.5.27
-- PHP-Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `scheduler_db`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `opcatalogues`
--

CREATE TABLE IF NOT EXISTS `opcatalogues` (
  `CatalogID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Description` varchar(300) DEFAULT NULL,
  `SpecialTrunk` tinyint(1) NOT NULL DEFAULT '0',
  `Level1OpNo` int(11) DEFAULT NULL,
  `Level2OpNo` int(11) DEFAULT NULL,
  `Level3OpNo` int(11) DEFAULT NULL,
  `BlockSize` int(11) NOT NULL DEFAULT '0',
  `MonthlyCapacity` int(11) NOT NULL DEFAULT '0',
  `SpecialtyID` int(11) NOT NULL,
  PRIMARY KEY (`CatalogID`),
  KEY `CatalogID` (`CatalogID`),
  KEY `Name` (`Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Daten für Tabelle `opcatalogues`
--

INSERT INTO `opcatalogues` (`CatalogID`, `Name`, `Description`, `SpecialTrunk`, `Level1OpNo`, `Level2OpNo`, `Level3OpNo`, `BlockSize`, `MonthlyCapacity`, `SpecialtyID`) VALUES
(1, 'Blood vessel', 'Operations done on any blood vessels. Codes that begin with 5-38, 5-39.', 1, 25, 0, 0, 5, 35, 3),
(2, 'Breast', '', 1, 2, 5, 3, 1, 2, 3),
(3, 'Cholecystectomy', '', 1, 0, 25, 0, 5, 1, 3),
(4, 'Difficult', '', 1, 0, 0, 25, 5, 5, 3),
(5, 'Stomache', '', 1, 100, 50, 30, 10, 160, 3),
(6, 'Head', '', 1, 0, 25, 0, 5, 2, 3),
(7, 'Hernia', '', 1, 20, 30, 0, 5, 25, 3);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
