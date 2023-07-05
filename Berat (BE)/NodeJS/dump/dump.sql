SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;

DROP DATABASE IF EXISTS berat;
CREATE DATABASE IF NOT EXISTS berat;
USE berat;

CREATE TABLE IF NOT EXISTS `weights` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `max_weight` int NOT NULL,
  `min_weight` int NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `weights` (`id`, `date`, `max_weight`, `min_weight`) VALUES
(1, '2018-08-22', 50, 49),
(2, '2018-08-21', 49, 49),
(3, '2018-08-20', 52, 50),
(4, '2018-08-19', 51, 50),
(5, '2018-08-18', 50, 48);

COMMIT;
