
CREATE DATABASE IF NOT EXISTS `spring_boot_udemy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring_boot_udemy`;

CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adress` varchar(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `gender` varchar(9) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) 
