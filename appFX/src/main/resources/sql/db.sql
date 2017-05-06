— —---------------------------------------------------
— Table `Student`.`country`
— —---------------------------------------------------
CREATE TABLE `country` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

— —---------------------------------------------------
— Table `Student`.`region`
— —---------------------------------------------------
CREATE TABLE `region` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`country` INT(11) NOT NULL,
PRIMARY KEY (`id`),
KEY `fk_region_country_idx` (`country`),
CONSTRAINT `fk_region_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

— —---------------------------------------------------
— Table `Student`.`city`
— —---------------------------------------------------
CREATE TABLE `city` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`region` INT(11) NOT NULL,
PRIMARY KEY (`id`),
KEY `fk_city_region_idx` (`region`),
CONSTRAINT `fk_city_region` FOREIGN KEY (`region`) REFERENCES `region` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

— —---------------------------------------------------
— Table `Student`.`student`
— —---------------------------------------------------
CREATE TABLE `student` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`firstname` VARCHAR(45) NOT NULL,
`surname` VARCHAR(45) NOT NULL,
`gender` VARCHAR(10) NOT NULL,
`birthday` DATE NOT NULL,
`address` VARCHAR(45) NOT NULL,
`phone` VARCHAR(45) NOT NULL,
`city` INT(11) NOT NULL,
PRIMARY KEY (`id`),
KEY `fk_student_city_idx` (`city`),
CONSTRAINT `fk_student_city` FOREIGN KEY (`city`) REFERENCES `city` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;