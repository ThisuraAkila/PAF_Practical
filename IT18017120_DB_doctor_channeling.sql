-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 11:04 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor_channeling`
--

CREATE TABLE `doctor_channeling` (
  `channeling_id` int(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `patient_age` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `doctor_name` varchar(100) NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor_channeling`
--

INSERT INTO `doctor_channeling` (`channeling_id`, `patient_name`, `patient_age`, `contact`, `doctor_name`, `hospital_name`, `date`, `time`) VALUES
(24, 'Thisura Jayasinghe', '24', '0771153752', 'Dr.Saman Silva', 'Asiri Hospital', '2020-04-24', '6.00 - 9.00 AM'),
(25, 'Sunil Perera', '35', '0717883101', 'Dr.Nimal Perera', 'Nawaloka Hospital', '2020-04-27', '9.00 - 12.00 AM'),
(26, 'Kamal Rajapakshe', '30', '0779966321', 'Dr.Herath', 'Ruhunu Hospital', '2020-04-24', '3.00 - 6.00 PM'),
(27, 'Isuru Dias', '22', '0714562137', 'Dr. Shanika Perera', 'Asiri Hospital', '2020-04-24', '3.00 - 6.00 PM'),
(28, 'Amal Perera', '40', '0775566332', 'Dr.Perera', 'Nawaloka Hospital', '2020-04-24', '9.00 - 12.00 AM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor_channeling`
--
ALTER TABLE `doctor_channeling`
  ADD PRIMARY KEY (`channeling_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor_channeling`
--
ALTER TABLE `doctor_channeling`
  MODIFY `channeling_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
