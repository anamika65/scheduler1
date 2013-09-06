-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 09. Feb 2013 um 12:03
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
-- Tabellenstruktur für Tabelle `opblocks`
--

CREATE TABLE IF NOT EXISTS `opblocks` (
  `OpBlockID` int(11) NOT NULL AUTO_INCREMENT,
  `CatalogID` int(11) NOT NULL,
  `Type` varchar(30) DEFAULT NULL,
  `DefaultSize` int(11) DEFAULT NULL,
  `ActualSize` int(11) DEFAULT NULL,
  `EarliestStartDate` date DEFAULT NULL,
  `LatestStartDate` date DEFAULT NULL,
  `DifficultyLevel` varchar(30) DEFAULT NULL,
  `ProjID` int(11) NOT NULL,
  PRIMARY KEY (`OpBlockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
