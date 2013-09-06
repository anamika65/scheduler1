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
-- Tabellenstruktur für Tabelle `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `ProjID` int(11) NOT NULL AUTO_INCREMENT,
  `PersID` int(11) NOT NULL,
  `StartDate` date DEFAULT NULL,
  `DeactivatedUntil` date DEFAULT NULL,
  `Duration` int(11) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `Active` boolean NOT NULL DEFAULT '1',
  `Nickname` varchar(30) NOT NULL,
  `SpecialtyID` int(11) NOT NULL,
  PRIMARY KEY (`ProjID`),
  UNIQUE KEY `Nickname` (`Nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
