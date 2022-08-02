-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-08-2022 a las 23:02:24
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `springboot`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` double DEFAULT NULL,
  `number` bigint(20) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `UK_dbfiubqahb32ns85k023gr6nn` (`number`),
  KEY `FKkm8yb63h4ownvnlrbwnadntyn` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `account`
--

INSERT INTO `account` (`account_id`, `balance`, `number`, `status`, `type`, `client_id`) VALUES
(1, 920, 1978306145, b'1', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`password`, `status`, `person_id`) VALUES
('4724', b'1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dni` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `UK_elp5gmwf3ngplkew2g20s0nra` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`person_id`, `address`, `age`, `dni`, `gender`, `last_name`, `name`, `phone`) VALUES
(1, 'fake street 123', 30, '0999999991', '1', 'Doe 2', 'Jhon', '0990511347');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balance` double DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK6g20fcr3bhr6bihgy24rq1r1b` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `balance`, `date_time`, `type`, `value`, `account_id`) VALUES
(1, 900, '2022-08-02 03:21:45', 1, -100, 1),
(2, 910, '2022-08-02 03:21:59', 1, 10, 1),
(3, 920, '2022-08-02 03:22:03', 1, 10, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FKkm8yb63h4ownvnlrbwnadntyn` FOREIGN KEY (`client_id`) REFERENCES `client` (`person_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKkxflpsue6s9kscgmuwt7ob1f3` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`);

--
-- Filtros para la tabla `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FK6g20fcr3bhr6bihgy24rq1r1b` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
