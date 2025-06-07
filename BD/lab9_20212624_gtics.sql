-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab9
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lab9` ;

-- -----------------------------------------------------
-- Schema lab9
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab9` DEFAULT CHARACTER SET utf8 ;
USE `lab9` ;

-- -----------------------------------------------------
-- Table `lab9`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab9`.`proveedores` (
  `idproveedores` INT NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(100) NULL,
  `nombre_comercial` VARCHAR(100) NULL,
  `ruc` INT(11) NULL,
  `telefono` INT NULL,
  `correo` VARCHAR(255) NULL,
  `web` VARCHAR(255) NULL,
  `direccion` VARCHAR(150) NULL,
  `pais` VARCHAR(255) NULL,
  `representante_legal` VARCHAR(255) NULL,
  `tipo_de_proveedor` VARCHAR(20) NULL,
  `categoria` VARCHAR(20) NULL,
  `facturacion_dolares` DECIMAL(10,10) NULL,
  `fecha_registro` DATETIME NULL,
  `ultima_actualizacion` DATETIME NULL,
  `estado` TINYINT NULL,
  PRIMARY KEY (`idproveedores`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
