-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 10, 2013 at 09:21 PM
-- Server version: 5.5.24
-- PHP Version: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `virtualST`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_master`
--

CREATE TABLE IF NOT EXISTS `admin_master` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `details` varchar(100) NOT NULL,
  PRIMARY KEY (`adminId`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `broker_master`
--

CREATE TABLE IF NOT EXISTS `broker_master` (
  `broker_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `broker_name` varchar(50) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `correspond_office` varchar(100) NOT NULL,
  `stat` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `clearing_no` varchar(50) NOT NULL,
  `trade_name` varchar(100) NOT NULL,
  `corporate_email` varchar(50) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `sebi_no` varchar(15) NOT NULL,
  `deposit` double NOT NULL,
  `fund` double NOT NULL,
  PRIMARY KEY (`broker_id`),
  KEY `user_id` (`user_id`),
  KEY `stat` (`stat`),
  KEY `city` (`city`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `broker_master`
--

INSERT INTO `broker_master` (`broker_id`, `broker_name`, `user_id`, `correspond_office`, `stat`, `city`, `clearing_no`, `trade_name`, `corporate_email`, `phone_no`, `sebi_no`, `deposit`, `fund`) VALUES
(6, 'juned ansari', 'juned', 'jay ambe', 'Gujarat', 'Surat', '5000', 'rushit', 'www.pop@yahhoo.com', '9968655963', '5000', 1000, 30940.634727499997);

-- --------------------------------------------------------

--
-- Table structure for table `city_master`
--

CREATE TABLE IF NOT EXISTS `city_master` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  `state_id` int(11) NOT NULL,
  PRIMARY KEY (`city_id`),
  KEY `state_id` (`state_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `city_master`
--

INSERT INTO `city_master` (`city_id`, `city_name`, `state_id`) VALUES
(1, 'Surat', 1),
(2, 'Anand', 1),
(3, 'Mumbai', 2),
(4, 'Pune', 2),
(5, 'Jaipur', 3),
(6, 'Bhilad', 3);

-- --------------------------------------------------------

--
-- Table structure for table `news_master`
--

CREATE TABLE IF NOT EXISTS `news_master` (
  `news_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(100) NOT NULL,
  `news_date` date NOT NULL,
  `details` varchar(11000) NOT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `news_master`
--

INSERT INTO `news_master` (`news_id`, `topic`, `news_date`, `details`) VALUES
(5, ' China Soybean output', '2013-01-04', 'Soybean output of China for 2012 seen at 13 million tons.\r\nThe output is 10.25 percent down as compared to same.'),
(6, 'Brazil & Argentina to raise Soybean imports', '2013-01-04', 'Brazil and Argentina will raise soybean imports in coming months following poor crops.\r\nBrazil and Argentina w..\r\n'),
(7, ' 2011-12 season ', '2013-01-04', 'Indiaâ??s Castor seed prices during the second quarter of 2012 dropped on the back of higher production compared to overall consumption. India covered 12.78 lakh h.'),
(8, ' China commercial crude oil ', '2013-01-05', 'China''s commercial crude inventories were up 3.1 percent at the end of July from June.'),
(9, 'AA company''s worth -', '2013-01-05', 'A company''s worth - its total value - is its market capitalization, and it is represented by the company''s stock price. Market cap (as it is commonly referred to) is equal to the stock price multiplied by the number of shares outstanding. \r\n'),
(10, 'a company will pay an investment bank ', '2013-01-05', 'a company will pay an investment bank a lot of money to use very complex formulas and valuation techniques to derive a company''s value by determining how many shares will be offered to the public and at what price." So our question that should spur from this answer is. "What are the (very complex formulas and valuation techniques)? I want a definitive way of determining a stock price, otherwise, I wouldn''t be able to tell someone why AAPL''s stock should be worth $666 or $6.66'),
(11, 'share prices are', '2013-01-05', 'share prices are set by trading managers and is computer guided like bettting odds at a bookmakers group; if they get it wrong they are sacked and many are!'),
(12, 'The the price continues to fall', '2013-01-05', 'he price for a stock is determined using an auction system. The price, unlike that of most consumer\npurchases, changes by the minute depending on the value investors place on the stock. If the price of a pair of\njeans is too high it is reduced (â??goes on saleâ??) until it is bought. If still not purchased, the jeans are destroyed.\nWith stocks, the price continues to fall until someone buys.\n');

-- --------------------------------------------------------

--
-- Table structure for table `order_master`
--

CREATE TABLE IF NOT EXISTS `order_master` (
  `order_id` double NOT NULL AUTO_INCREMENT,
  `trader_id` double NOT NULL,
  `volume` bigint(11) NOT NULL,
  `price` double NOT NULL,
  `script_id` varchar(50) NOT NULL,
  `order_date` date NOT NULL,
  `order_type` varchar(1) NOT NULL,
  `pending` varchar(5) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `trader_id` (`trader_id`,`script_id`),
  KEY `script_id` (`script_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `order_master`
--

INSERT INTO `order_master` (`order_id`, `trader_id`, `volume`, `price`, `script_id`, `order_date`, `order_type`, `pending`) VALUES
(3, 1, 20, 30, 'FB', '2013-01-01', 'B', 'no'),
(4, 2, 20, 8, 'AQ', '2013-01-01', 'B', 'no'),
(5, 1, 25, 33.32, 'ORCL', '2013-01-01', 'B', 'no'),
(7, 2, 30, 12, 'F', '2013-01-01', 'B', 'yes'),
(8, 1, 20, 39.02, 'M', '2013-01-01', 'S', 'no'),
(9, 1, 20, 36.25, 'KO', '2013-01-01', 'B', 'no'),
(10, 2, 5, 5, 'IO', '2013-01-01', 'B', 'yes'),
(11, 1, 15, 100, 'KO', '2013-01-01', 'S', 'yes'),
(12, 1, 10, 26.6197, 'FB', '2013-01-05', 'S', 'no'),
(13, 2, 1, 80, 'AQ', '2013-01-01', 'S', 'yes'),
(14, 2, 50, 38.57, 'H', '2013-01-01', 'B', 'no'),
(15, 1, 15, 100, 'ORCL', '2013-01-01', 'S', 'yes'),
(16, 1, 2, 29.4213, 'FB', '2013-01-05', 'B', 'no'),
(17, 1, 5, 1.72, 'MSN', '2013-01-05', 'B', 'no'),
(18, 1, 20, 25.5, 'FB', '2013-01-05', 'B', 'yes'),
(19, 2, 20, 8.99, 'WIT', '2013-01-05', 'B', 'no'),
(20, 2, 20, 37.3, 'KO', '2013-01-05', 'B', 'no'),
(21, 1, 20, 25.5, 'RS', '2013-01-05', 'B', 'yes'),
(22, 2, 20, 25.5, 'MSFT', '2013-01-08', 'B', 'yes'),
(23, 1, 20, 26.55, 'MSFT', '2013-01-08', 'B', 'no'),
(24, 2, 10, 7.3465, 'AQ', '2013-01-08', 'S', 'no'),
(25, 1, 5, 34.5815, 'ORCL', '2013-01-08', 'S', 'no'),
(26, 2, 3, 76.89, 'UPS', '2013-01-08', 'B', 'no'),
(27, 2, 20, 35.69, 'KCE', '2013-01-08', 'B', 'no'),
(28, 2, 20, 35.69, 'KCE', '2013-01-08', 'B', 'no'),
(29, 1, 500, 11.3, 'MDR', '2013-01-09', 'B', 'yes'),
(30, 2, 230, 9.5, 'PCS', '2013-01-09', 'B', 'yes'),
(31, 1, 5, 2, 'MSN', '2013-01-10', 'S', 'yes'),
(32, 2, 200, 9.83, 'MDRX', '2013-01-10', 'B', 'yes'),
(33, 1, 100, 9.83, 'MDRX', '2013-01-10', 'B', 'yes'),
(34, 2, 35, 10, 'H', '2013-01-10', 'S', 'yes'),
(35, 1, 15, 10, 'M', '2013-01-10', 'S', 'yes'),
(36, 1, 10, 15, 'KO', '2013-01-10', 'S', 'yes'),
(37, 1, 5, 20, 'MSN', '2013-01-10', 'S', 'yes'),
(38, 2, 26, 20, 'KCE', '2013-01-10', 'S', 'yes'),
(39, 2, 150, 14, 'FBNK', '2013-01-10', 'B', 'yes'),
(40, 2, 150, 14, 'FBNK', '2013-01-10', 'B', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `registration_mst`
--

CREATE TABLE IF NOT EXISTS `registration_mst` (
  `guest_id` int(11) NOT NULL AUTO_INCREMENT,
  `guest_name` varchar(100) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `stat` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `panNo` varchar(11) NOT NULL,
  `broker_id` bigint(20) NOT NULL,
  `pending` varchar(10) NOT NULL,
  PRIMARY KEY (`guest_id`),
  KEY `broker_id` (`broker_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `registration_mst`
--

INSERT INTO `registration_mst` (`guest_id`, `guest_name`, `email_id`, `phone_no`, `address`, `stat`, `city`, `pincode`, `panNo`, `broker_id`, `pending`) VALUES
(1, 'Vijay Kachadiya', 'rishi@yha.in', 'Yes', 'adsdqdq', 'Gujarat', 'Surat', 'Yes', '1234567', 6, 'Yes'),
(2, 'chirag jokhakhar', 'pareshradadiya@hotmail.com', '8128969396', '247 shubh laxmi', 'Maharastra', 'Mumbai', '395006', '6', 6, 'No');

-- --------------------------------------------------------

--
-- Table structure for table `state_master`
--

CREATE TABLE IF NOT EXISTS `state_master` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(100) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `state_master`
--

INSERT INTO `state_master` (`state_id`, `state_name`) VALUES
(1, 'Gujarat'),
(2, 'Maharastra'),
(3, 'Rajasthan');

-- --------------------------------------------------------

--
-- Table structure for table `stock_details`
--

CREATE TABLE IF NOT EXISTS `stock_details` (
  `script_id` varchar(50) NOT NULL,
  `script_code` varchar(20) NOT NULL,
  `group_type` varchar(20) NOT NULL,
  `industry` varchar(50) NOT NULL,
  `market_lot` int(11) NOT NULL,
  `listing_date` date NOT NULL,
  `face_value` int(11) NOT NULL,
  `company_name` varchar(500) NOT NULL,
  `address` varchar(100) NOT NULL,
  `stat` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `fax` varchar(15) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `director` varchar(50) NOT NULL,
  `website` varchar(50) NOT NULL,
  PRIMARY KEY (`script_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_details`
--

INSERT INTO `stock_details` (`script_id`, `script_code`, `group_type`, `industry`, `market_lot`, `listing_date`, `face_value`, `company_name`, `address`, `stat`, `city`, `phone_no`, `fax`, `email_id`, `director`, `website`) VALUES
('AQ', 'AQ', '', '', 0, '2013-01-01', 0, '', '', '', '', '', '', '', '', ''),
('BA', 'BA', '', '', 0, '2012-12-18', 0, '"Boeing Company (T"', '', '', '', '', '', '', '', ''),
('DELL', 'DELL', '', '', 0, '2012-12-17', 0, '', '', '', '', '', '', '', '', ''),
('F', 'F', '', '', 0, '2013-01-01', 0, '', '', '', '', '', '', '', '', ''),
('FB', 'FB', '', '', 0, '2012-12-18', 0, '', '', '', '', '', '', '', '', ''),
('FBNK', 'FBNK', '', '', 0, '2013-01-10', 0, 'First Connecticut', '', '', '', '', '', '', '', ''),
('H', 'H', '', '', 0, '2013-01-01', 0, '', '', '', '', '', '', '', '', ''),
('IO', 'IO', '', '', 0, '2013-01-01', 0, '', '', '', '', '', '', '', '', ''),
('KCE', 'KCE', '', '', 0, '2013-01-08', 0, 'SPDR S&P Capital ', '', '', '', '', '', '', '', ''),
('KO', 'KO', '', '', 0, '2013-01-01', 0, '', '', '', '', '', '', '', '', ''),
('M', 'M', '', '', 0, '2013-01-01', 0, '', '', '', '', '', '', '', '', ''),
('MDR', 'MDR', '', '', 0, '2013-01-09', 0, 'McDermott Interna', '', '', '', '', '', '', '', ''),
('MDRX', 'MDRX', '', '', 0, '2013-01-10', 0, 'Allscripts Health', '', '', '', '', '', '', '', ''),
('MSFT', 'MSFT', 'B', 'Automobile', 0, '2013-01-07', 0, 'Microsoft Corpora', '247-shubh laxmi soc,\r\nnana varacha,\r\nsurat', 'Maharastra', 'Mumbai', '48454112154', '123456', 'pareshradadiya@hotmail.com', '1000.0', 'https://www.pop.cpm'),
('MSN', 'MSN', '', '', 0, '2012-12-18', 0, '"Emerson Radio Cor"', '', '', '', '', '', '', '', ''),
('ORCL', 'ORCL', '', '', 0, '2012-12-17', 0, '"Oracle Corporatio"', '', '', '', '', '', '', '', ''),
('PCS', 'PCS', '', '', 0, '2013-01-09', 0, 'MetroPCS Communic', '', '', '', '', '', '', '', ''),
('RS', 'RS', '', '', 0, '2013-01-05', 0, 'Reliance Steel & ', '', '', '', '', '', '', '', ''),
('UPS', 'UPS', '', '', 0, '2013-01-08', 0, 'United Parcel Ser', '', '', '', '', '', '', '', ''),
('WIT', 'WIT', '', '', 0, '2013-01-05', 0, '', '', '', '', '', '', '', '', ''),
('YHOO', 'YHOO', '', '', 0, '2012-12-17', 0, '"Yahoo! Inc."', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `trader_master`
--

CREATE TABLE IF NOT EXISTS `trader_master` (
  `trader_id` double NOT NULL AUTO_INCREMENT,
  `trader_name` varchar(100) NOT NULL,
  `broker_id` bigint(11) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `deposit` double NOT NULL,
  `address` varchar(100) NOT NULL,
  `stat` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `pan_no` varchar(20) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `fund` double NOT NULL,
  PRIMARY KEY (`trader_id`),
  KEY `user_id` (`user_id`),
  KEY `broker_id` (`broker_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `trader_master`
--

INSERT INTO `trader_master` (`trader_id`, `trader_name`, `broker_id`, `user_id`, `deposit`, `address`, `stat`, `city`, `pan_no`, `phone_no`, `email_id`, `fund`) VALUES
(1, 'Paresh Radadiya', 6, 'Paresh Radadiya', 50000, '247-Shub Laxmi Soc,nana Varachha', 'Gujarat', 'Surat', '8UAns872snb', '5454561151', 'pareshpatel@yahoo.com', 106911.2427835),
(2, 'Sachin Dabhi', 6, 'Sachin Dabhi', 70000, '58,Ganesh Part,Batiya Bazzar', 'Gujarat', 'Anand', '5sd78242j87', '9033718174', 'pareshpatel@yahoo.com', 135335.59147499996),
(3, 'rushit', 6, 'rushit', 1000000, 'alkapuri', 'Rajasthan', 'Bhilad', '6555srdkkaj', '9725701120', 'Rushit.patel@gmail.com', 0),
(4, 'chirag jokhakhar', 6, 'chirag jokhakhar', 0, '247 shubh laxmi', 'Maharastra', 'Mumbai', '6', '8128969396', 'pareshradadiya@hotmail.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `trader_stock`
--

CREATE TABLE IF NOT EXISTS `trader_stock` (
  `trader` double NOT NULL,
  `script` varchar(50) NOT NULL,
  `volume` bigint(11) NOT NULL,
  PRIMARY KEY (`trader`,`script`),
  KEY `trader_id` (`trader`,`script`),
  KEY `script_id` (`script`),
  KEY `trader_id_2` (`trader`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trader_stock`
--

INSERT INTO `trader_stock` (`trader`, `script`, `volume`) VALUES
(1, 'FB', 12),
(1, 'KO', 20),
(1, 'M', 20),
(1, 'MSFT', 20),
(1, 'MSN', 5),
(1, 'ORCL', 20),
(2, 'AQ', 10),
(2, 'H', 50),
(2, 'KCE', 40),
(2, 'KO', 20),
(2, 'UPS', 3),
(2, 'WIT', 20);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_details`
--

CREATE TABLE IF NOT EXISTS `transaction_details` (
  `trans_id` double NOT NULL AUTO_INCREMENT,
  `order_id` double NOT NULL,
  `trans_date` date NOT NULL,
  `brokrage` double NOT NULL,
  PRIMARY KEY (`trans_id`),
  KEY `buyer_id` (`order_id`),
  KEY `buyer_id_2` (`order_id`),
  KEY `buyer_id_3` (`order_id`),
  KEY `buyer_id_4` (`order_id`),
  KEY `buyer_id_5` (`order_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `transaction_details`
--

INSERT INTO `transaction_details` (`trans_id`, `order_id`, `trans_date`, `brokrage`) VALUES
(1, 3, '2013-01-01', 7.9859100000000005),
(2, 4, '2013-01-01', 2.3129999999999997),
(3, 5, '2013-01-01', 12.495),
(4, 8, '2013-02-01', 11.706000000000001),
(5, 9, '2013-01-01', 10.875),
(6, 12, '2013-01-08', 3.9929550000000003),
(7, 14, '2013-01-01', 28.9275),
(8, 17, '2013-02-01', 0.12899999999999998),
(9, 16, '2013-01-07', 0.882639),
(10, 20, '2013-02-01', 11.19),
(11, 19, '2013-01-07', 2.6970000000000005),
(12, 23, '2013-01-08', 7.965),
(13, 25, '2013-01-08', 2.5936125),
(14, 24, '2013-01-08', 1.1019750000000001),
(15, 26, '2013-01-08', 3.46005),
(16, 27, '2013-01-08', 10.706999999999999),
(17, 28, '2013-01-08', 10.706999999999999);

-- --------------------------------------------------------

--
-- Table structure for table `user_group`
--

CREATE TABLE IF NOT EXISTS `user_group` (
  `user_id` varchar(100) NOT NULL,
  `group_type` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`group_type`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_group`
--

INSERT INTO `user_group` (`user_id`, `group_type`) VALUES
('chirag jokhakhar', 'trader'),
('juned', 'broker'),
('Kali', 'trader'),
('katrina', 'trader'),
('Paresh Radadiya', 'trader'),
('pop', 'admin'),
('rushit', 'trader'),
('Rushit Patel', 'admin'),
('Sachin Dabhi', 'trader'),
('sunny lione', 'broker'),
('tony', 'trader'),
('Viral', 'trader'),
('Vivek Shah', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `user_master`
--

CREATE TABLE IF NOT EXISTS `user_master` (
  `user_id` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_master`
--

INSERT INTO `user_master` (`user_id`, `password`) VALUES
('chirag jokhakhar', 'b9c7adecc8047cb51e513b9f5ccc9660'),
('juned', '4769ad580a03eae7501b5852ea17b82a'),
('Kali', 'e16f5edcf6016868e6184a3b5043ce8'),
('katrina', '3d7f65f5dcc8ef953f7d9a06f2477cc4'),
('kirtan', '98ba7779dd2f7362f676269e00d677b6'),
('Paresh Radadiya', '33d72cb38c7a1d95ca87a22bb4cafc03'),
('pop', 'b21afc54fb48d153c19101658f4a2a48'),
('rushit', '419a4fbf7af47d2533de38af63067ef9'),
('Rushit Patel', '6b70adda68d1f22852aa2347285a8663'),
('Sachin Dabhi', '93c6a60a1d8b4df7dab9f46f74c736bc'),
('sunny lione', '533c5ba8368075db8f6ef201546bd71a'),
('tony', 'ddc5f5e86d2f85e1b1ff763aff13ce0a'),
('Viral', '15511ee2b52f842f0d5e3a73eb9b015e'),
('Vivek Shah', '8268be230534346dfae836fecaa5f22d');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_master`
--
ALTER TABLE `admin_master`
  ADD CONSTRAINT `admin_master_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `broker_master`
--
ALTER TABLE `broker_master`
  ADD CONSTRAINT `broker_master_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  ADD CONSTRAINT `FK_broker_master_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `city_master`
--
ALTER TABLE `city_master`
  ADD CONSTRAINT `city_master_ibfk_2` FOREIGN KEY (`state_id`) REFERENCES `state_master` (`state_id`);

--
-- Constraints for table `order_master`
--
ALTER TABLE `order_master`
  ADD CONSTRAINT `FK_order_master_script_id` FOREIGN KEY (`script_id`) REFERENCES `stock_details` (`script_id`),
  ADD CONSTRAINT `order_master_ibfk_4` FOREIGN KEY (`script_id`) REFERENCES `stock_details` (`script_id`),
  ADD CONSTRAINT `order_master_ibfk_5` FOREIGN KEY (`trader_id`) REFERENCES `trader_master` (`trader_id`);

--
-- Constraints for table `registration_mst`
--
ALTER TABLE `registration_mst`
  ADD CONSTRAINT `registration_mst_ibfk_1` FOREIGN KEY (`broker_id`) REFERENCES `broker_master` (`broker_id`);

--
-- Constraints for table `trader_master`
--
ALTER TABLE `trader_master`
  ADD CONSTRAINT `trader_master_ibfk_1` FOREIGN KEY (`broker_id`) REFERENCES `broker_master` (`broker_id`),
  ADD CONSTRAINT `trader_master_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `trader_stock`
--
ALTER TABLE `trader_stock`
  ADD CONSTRAINT `trader_stock_ibfk_1` FOREIGN KEY (`trader`) REFERENCES `trader_master` (`trader_id`),
  ADD CONSTRAINT `trader_stock_ibfk_2` FOREIGN KEY (`script`) REFERENCES `stock_details` (`script_id`);

--
-- Constraints for table `transaction_details`
--
ALTER TABLE `transaction_details`
  ADD CONSTRAINT `transaction_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_master` (`order_id`);

--
-- Constraints for table `user_group`
--
ALTER TABLE `user_group`
  ADD CONSTRAINT `user_group_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
