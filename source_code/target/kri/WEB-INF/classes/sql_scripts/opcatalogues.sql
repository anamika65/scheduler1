-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 02, 2014 at 12:03 PM
-- Server version: 5.6.12
-- PHP Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `scheduler_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `opcatalogues`
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
  `TrainSystemID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CatalogID`),
  KEY `CatalogID` (`CatalogID`),
  KEY `Name` (`Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `opcatalogues`
--

INSERT INTO `opcatalogues` (`CatalogID`, `Name`, `Description`, `SpecialTrunk`, `Level1OpNo`, `Level2OpNo`, `Level3OpNo`, `BlockSize`, `MonthlyCapacity`, `SpecialtyID`, `TrainSystemID`) VALUES
(1, 'Blood vessel', 'Operations done on any blood vessels. Codes that begin with 5-38, 5-39.', 1, 25, 0, 0, 5, 35, 3, 1),
(2, 'Breast', '', 1, 2, 5, 3, 1, 2, 3, 2),
(3, 'Cholecystectomy', '', 1, 0, 25, 0, 5, 1, 3, 2),
(4, 'Difficult', '', 1, 0, 0, 25, 5, 5, 3, 2),
(5, 'Stomache', '', 1, 100, 50, 30, 10, 160, 3, 1),
(6, 'Head', '', 1, 0, 25, 0, 5, 2, 3, 1),
(7, 'Hernia', '', 1, 20, 30, 0, 5, 25, 3, 2),
(16, 'fdf', 'fgfg', 1, 1, 1, 1, 0, 0, 3, 1),
(18, 'kjhkjhkh', 'kjhjk', 1, 1, 2, 3, 0, 0, 3, 1),
(20, 'fdg', 'gfdg', 1, 3, 57, 7, 0, 0, 3, NULL),
(23, 'test', '', 1, 2, 31, 1, 0, 0, 3, 1),
(24, 'fdgfg', 'ghgjhg', 1, 1, 3, 4, 0, 0, 3, 2),
(25, 'test', 'sdfjhkk', 1, 2, 2, 1, 0, 0, 3, 2),
(26, 'hello', 'jhgjhg', 1, 2, 1, 1, 0, 0, 3, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
