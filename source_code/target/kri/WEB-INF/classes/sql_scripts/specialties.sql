-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Mrz 2013 um 21:19
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
-- Tabellenstruktur für Tabelle `specialties`
--

CREATE TABLE IF NOT EXISTS `specialties` (
  `SpecialtyID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`SpecialtyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO `specialties` (`SpecialtyID`, `Name`) VALUES
(0, 'General Surgery'),
(1, 'Cardiac Surgery'),
(2, 'Vascular Surgery'),
(3, 'Trauma Surgery');
