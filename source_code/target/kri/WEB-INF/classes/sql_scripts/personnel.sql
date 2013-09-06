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
-- Tabellenstruktur für Tabelle `personnel`
--

CREATE TABLE IF NOT EXISTS `personnel` (
  `PersID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `FirstName` varchar(30) DEFAULT NULL,
  `Title` varchar(30) DEFAULT NULL,
  `Function` varchar(30) DEFAULT NULL,
  `Nickname` varchar(30) NOT NULL,
  PRIMARY KEY (`PersID`),
  UNIQUE KEY `Nickname` (`Nickname`)  
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `personnel`
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


--
-- Trigger `personnel`
--
DROP TRIGGER IF EXISTS `personnel_AUPD`;
DELIMITER //
CREATE TRIGGER `personnel_AUPD` AFTER UPDATE ON `personnel`
FOR EACH ROW 
-- Edit trigger body code below this line. Do not edit lines above this one
UPDATE project SET Nickname = NEW.Nickname 
		WHERE PersID = NEW.PersID
//
DELIMITER ;