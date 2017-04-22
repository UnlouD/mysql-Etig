CREATE SCHEMA IF NOT EXISTS `Project` DEFAULT CHARACTER SET utf8 ;
USE `Project` ;

-- -----------------------------------------------------
-- Table `Project`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Project`.`country` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Project`.`Region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Project`.`region` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `country` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_region_country_idx` (`country` ASC),
  CONSTRAINT `fk_region_rountry`
  FOREIGN KEY (`country`)
  REFERENCES `Project`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Project`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Project`.`city` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `region` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region_idx` (`region` ASC),
  CONSTRAINT `fk_city_region`
  FOREIGN KEY (`region`)
  REFERENCES `Project`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Project`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Project`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(5) NOT NULL,
  `birthday` DATE NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `city` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_city_idx` (`city` ASC),
  CONSTRAINT `fk_student_city`
  FOREIGN KEY (`city`)
  REFERENCES `Project`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;