-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 13, 2018 at 01:03 PM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `18f315_Nana`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `Locals`
--
DROP VIEW IF EXISTS `Locals`;
CREATE TABLE IF NOT EXISTS `Locals` (
`firstname` varchar(45)
,`lastname` varchar(45)
,`email` varchar(45)
,`phone` varchar(45)
);

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `skillID` int(11) NOT NULL AUTO_INCREMENT,
  `skillname` varchar(45) DEFAULT NULL,
  `skillDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`skillID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(1, 'Swimming', 'This is a test');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(2, 'Mathematics', 'This is maths');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(3, 'Science', 'This is science');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(4, 'French', 'French');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(20, 'Accounting', 'the occupation of maintaining and auditing records and preparing financial reports for a business');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(21, 'Branding', 'the act of stigmatizing');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(22, 'Coaching', 'the job of a professional coach');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(23, 'Communications', 'the discipline that studies the principles of transmiting information and the methods by by which it is delivered (as print or radio or television etc.)');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(24, 'Data Analysis', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(25, 'Database Administration', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(26, 'Digital Marketing', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(27, 'Engineering', 'the practical application of science to commerce or industry ');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(28, 'Entrepreneurship', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(29, 'Event Planning', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(30, 'Finance', 'the commercial activity of providing funds and capital ');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(31, 'Fundraising', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(32, 'Graphic Design', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(33, 'Human Resources', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(34, 'Information Technology', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(35, 'Photography & Video', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(36, 'Public Relations', 'a promotion intended to create goodwill for a person or institution');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(37, 'Research', 'systematic investigation to establish facts ');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(38, 'Sales', 'income (at invoice values) received for goods and services over some given period of time');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(39, 'Social Media', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(40, 'Sound Editing', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(41, 'Strategy Consulting', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(42, 'Training', 'activity leading to skilled behavior ');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(43, 'Web Design', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(44, 'Web Development', ' We\'re sorry, but this word returned zero results');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(47, 'This is a Skill', 'wd');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(48, 'Dancing', 'Dancing');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(49, 'Linguistics', 'Speaks many languages');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(50, '', '');
INSERT INTO `skill` (`skillID`, `skillname`, `skillDescription`) VALUES(51, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `skill_index`
--

DROP TABLE IF EXISTS `skill_index`;
CREATE TABLE IF NOT EXISTS `skill_index` (
  `skillIndexID` int(11) NOT NULL AUTO_INCREMENT,
  `skillID` int(11) DEFAULT NULL,
  `volunteerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`skillIndexID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skill_index`
--

INSERT INTO `skill_index` (`skillIndexID`, `skillID`, `volunteerID`) VALUES(2, 44, 2);
INSERT INTO `skill_index` (`skillIndexID`, `skillID`, `volunteerID`) VALUES(3, 25, 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
CREATE TABLE IF NOT EXISTS `volunteer` (
  `volunteerID` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `gender` varchar(1) DEFAULT 'M',
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `employer` varchar(45) DEFAULT NULL,
  `license` varchar(3) DEFAULT 'Yes',
  PRIMARY KEY (`volunteerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `volunteer`
--

INSERT INTO `volunteer` (`volunteerID`, `firstname`, `lastname`, `dob`, `gender`, `email`, `address`, `city`, `state`, `zipcode`, `phone`, `occupation`, `employer`, `license`) VALUES(2, 'Nana Ofosu', 'Budu', '2018-03-17 00:00:00', 'M', 'nanaofosu@email.com', '2211 W Birch Ave', 'Chicago ', 'IL', '60606', '123456789', 'Web Developer', 'UChicago', 'Yes');
INSERT INTO `volunteer` (`volunteerID`, `firstname`, `lastname`, `dob`, `gender`, `email`, `address`, `city`, `state`, `zipcode`, `phone`, `occupation`, `employer`, `license`) VALUES(3, 'Peter', 'Kimmel', '1912-12-06 00:00:00', 'M', 'peter@kimmel.com', '1600 Wes Oak St', 'Chicago', 'IL', '60609', '7739909999', 'Best Professor Ever', 'Northeastern Illinois University', 'Yes');

-- --------------------------------------------------------

--
-- Structure for view `Locals`
--
DROP TABLE IF EXISTS `Locals`;

CREATE ALGORITHM=UNDEFINED DEFINER=`18f315_Nana`@`%` SQL SECURITY DEFINER VIEW `Locals`  AS  select `volunteer`.`firstname` AS `firstname`,`volunteer`.`lastname` AS `lastname`,`volunteer`.`email` AS `email`,`volunteer`.`phone` AS `phone` from `volunteer` where (`volunteer`.`city` = 'Chicago') ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
