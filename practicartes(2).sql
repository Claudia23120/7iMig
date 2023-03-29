-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 15, 2022 at 12:03 PM
-- Server version: 5.7.30
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `m3_PracticaUF6`
--
CREATE DATABASE IF NOT EXISTS `m3_PracticaUF6` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `m3_PracticaUF6`;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `contrasenya` varchar(20) NOT NULL,
  `partidesJugades` int(11) DEFAULT '0',
  `partidesGuanyades` int(11) DEFAULT '0',
  `partidesPerdudes` int(11) DEFAULT '0',
  `punts` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nomUnic` (`nom`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;