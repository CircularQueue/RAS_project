-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 27, 2017 at 10:23 PM
-- Server version: 5.6.35
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `RAS2`
--

-- --------------------------------------------------------

--
-- Table structure for table `Employees`
--

CREATE TABLE `Employees` (
  `employeeID` int(3) NOT NULL,
  `Employee_name` varchar(75) NOT NULL,
  `Employee_type` varchar(25) NOT NULL,
  `working_now` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Employees`
--

INSERT INTO `Employees` (`employeeID`, `Employee_name`, `Employee_type`, `working_now`) VALUES
(1, 'Clara Oswald', 'Server', 0),
(2, 'Amy Pond', 'Server', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Tables`
--

CREATE TABLE `Tables` (
  `tableID` int(2) NOT NULL,
  `employeeID` int(3) NOT NULL,
  `max_occupancy` int(2) NOT NULL,
  `Table_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Tables`
--

INSERT INTO `Tables` (`tableID`, `employeeID`, `max_occupancy`, `Table_status`) VALUES
(1, 1, 6, 'empty'),
(2, 1, 6, 'empty'),
(3, 1, 8, 'empty'),
(4, 1, 10, 'empty'),
(5, 2, 5, 'empty'),
(6, 2, 5, 'empty'),
(7, 2, 7, 'empty'),
(8, 2, 8, 'empty');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Employees`
--
ALTER TABLE `Employees`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `Tables`
--
ALTER TABLE `Tables`
  ADD PRIMARY KEY (`tableID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Employees`
--
ALTER TABLE `Employees`
  MODIFY `employeeID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Tables`
--
ALTER TABLE `Tables`
  MODIFY `tableID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;