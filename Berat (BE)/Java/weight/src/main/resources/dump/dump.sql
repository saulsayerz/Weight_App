SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;

DROP DATABASE IF EXISTS berat;
CREATE DATABASE IF NOT EXISTS berat;
USE berat;

CREATE TABLE IF NOT EXISTS `weight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `berat_max` int NOT NULL,
  `berat_min` int NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `weight` (`id`, `tanggal`, `berat_max`, `berat_min`) VALUES
(1, '2018-08-22', 50, 49),
(2, '2018-08-21', 49, 49),
(3, '2018-08-20', 52, 50),
(4, '2018-08-19', 51, 50),
(5, '2018-08-18', 50, 48);

COMMIT;
