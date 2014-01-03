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
-- Table structure for table `training_systems`
--

CREATE TABLE IF NOT EXISTS `training_systems` (
  `train_system_id` int(20) NOT NULL AUTO_INCREMENT,
  `train_system_name` varchar(30) NOT NULL,
  PRIMARY KEY (`train_system_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `training_systems`
--

INSERT INTO `training_systems` (`train_system_id`, `train_system_name`) VALUES
(1, 'After 2004'),
(2, 'Before 2004'),
(3, 'Before 2009'),
(4, 'After 2012'),
(5, 'Before 2013');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
