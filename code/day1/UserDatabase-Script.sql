
DROP DATABASE IF EXISTS UserDatabase;
CREATE DATABASE UserDatabase DEFAULT CHAR SET utf8;

CREATE TABLE `UserDatabase`.`Employee` (
  `employeeId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `employeeNumber` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`employeeId`));
  
INSERT INTO `UserDatabase`.`Employee` (`firstName`, `lastName`, `employeeNumber`) 
VALUES ('Jones', 'Watson', '1001');

INSERT INTO `UserDatabase`.`Employee` (`firstName`, `lastName`, `employeeNumber`) 
VALUES ('Sherlock', 'Holmes', '2002');

INSERT INTO `UserDatabase`.`Employee` (`firstName`, `lastName`, `employeeNumber`) 
VALUES ('Master', 'Yoda', '3003');

