-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 03, 2022 at 01:37 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaform`
--

-- --------------------------------------------------------

--
-- Table structure for table `jform2`
--

CREATE TABLE `jform2` (
  `RollNo` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Branch` varchar(30) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `MobNumber` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jform2`
--

INSERT INTO `jform2` (`RollNo`, `Name`, `Address`, `Branch`, `Gender`, `MobNumber`) VALUES
(101, 'AvadhutPawar', 'Pune', 'Computer', 'male', 88066678),
(102, 'IshaBorgaonkar', 'Pune', 'Computer', 'Female', 98456322),
(103, 'SanjanaPawar', 'Pune', 'ENTC', 'Female', 746723),
(104, 'AdityaPatil', 'Pune', 'ENTC', 'male', 1111111);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
