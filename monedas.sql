CREATE DATABASE  IF NOT EXISTS `monedas`;
USE `monedas`;
DROP TABLE IF EXISTS `moneda`;
CREATE TABLE `moneda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denomina` varchar(45) NOT NULL,
  `numero` float NOT NULL,
  `idPais` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`idPais`) REFERENCES `pais` (`id`)
);
DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  );

