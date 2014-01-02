-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 02, 2014 at 12:02 PM
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
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `EmailID` varchar(30) NOT NULL,
  `SpecialtyID` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `active`, `username`, `password`, `EmailID`, `SpecialtyID`) VALUES
(3, 1, 'jghjgh', 'ansk', '', 0),
(7, 1, 'sakib', '1234', '', 0),
(9, 1, 'sakib', '1234', '', 0),
(10, 1, 'claus', '2345', '', 0),
(17, 1, 'anu4', '1234', '', 0),
(19, 1, 'test1', '1234', '', 0),
(20, 1, 'test2', '1234', '', 1),
(30, 1, 'anamika66', '12345', 'anamika.chowdhury@tum.de', 2),
(31, 1, 'gh', '1', 'anamika.chowdhury@tum.de', 0),
(32, 1, 'mustafiz', '123', 'mustafiz.apps@gmail.com', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
