SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `BattleBotDb` DEFAULT CHARACTER SET latin1 ;
USE `BattleBotDb` ;

-- -----------------------------------------------------
-- Table `BattleBotDb`.`Armor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BattleBotDb`.`Armor` ;

CREATE  TABLE IF NOT EXISTS `BattleBotDb`.`Armor` (
  `armorId` INT(11) NOT NULL AUTO_INCREMENT ,
  `armorNameTX` VARCHAR(50) NOT NULL ,
  `baseAcINT` INT(11) NOT NULL ,
  `dexHinderenceINT` INT(11) NOT NULL ,
  `modDT` DATETIME NOT NULL ,
  PRIMARY KEY (`armorId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `BattleBotDb`.`Effect`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BattleBotDb`.`Effect` ;

CREATE  TABLE IF NOT EXISTS `BattleBotDb`.`Effect` (
  `effectId` INT(11) NOT NULL AUTO_INCREMENT ,
  `effectName` VARCHAR(45) NOT NULL ,
  `modDT` DATETIME NOT NULL ,
  PRIMARY KEY (`effectId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `BattleBotDb`.`Weapon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BattleBotDb`.`Weapon` ;

CREATE  TABLE IF NOT EXISTS `BattleBotDb`.`Weapon` (
  `weaponId` INT(11) NOT NULL AUTO_INCREMENT ,
  `weaponNameTX` VARCHAR(50) NOT NULL ,
  `modDT` DATETIME NOT NULL ,
  PRIMARY KEY (`weaponId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `BattleBotDb`.`PlayerCharacter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BattleBotDb`.`PlayerCharacter` ;

CREATE  TABLE IF NOT EXISTS `BattleBotDb`.`PlayerCharacter` (
  `playerId` INT(11) NOT NULL AUTO_INCREMENT ,
  `playerNameTX` VARCHAR(50) NOT NULL ,
  `modDT` DATETIME NOT NULL ,
  `maxHp_INT` INT(11) NOT NULL ,
  `currentHp_INT` INT(11) NOT NULL ,
  `armorId` INT(11) NOT NULL DEFAULT 1 ,
  `weaponId` INT(11) NOT NULL DEFAULT 1 ,
  `experienceINT` INT(11) NOT NULL DEFAULT 0 ,
  `goldINT` INT(11) NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`playerId`) ,
  INDEX `fk_PlayerCharacter_Armor_idx` (`armorId` ASC) ,
  INDEX `fk_PlayerCharacter_Weapon1_idx` (`weaponId` ASC) ,
  CONSTRAINT `fk_PlayerCharacter_Armor`
    FOREIGN KEY (`armorId` )
    REFERENCES `BattleBotDb`.`Armor` (`armorId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PlayerCharacter_Weapon1`
    FOREIGN KEY (`weaponId` )
    REFERENCES `BattleBotDb`.`Weapon` (`weaponId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `BattleBotDb`.`WeaponEffects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BattleBotDb`.`WeaponEffects` ;

CREATE  TABLE IF NOT EXISTS `BattleBotDb`.`WeaponEffects` (
  `weaponId` INT(11) NOT NULL ,
  `effectId` INT(11) NOT NULL ,
  PRIMARY KEY (`weaponId`, `effectId`) ,
  INDEX `fk_WeaponEffects_Weapon1_idx` (`weaponId` ASC) ,
  INDEX `fk_WeaponEffects_Effect1_idx` (`effectId` ASC) ,
  CONSTRAINT `fk_WeaponEffects_Weapon1`
    FOREIGN KEY (`weaponId` )
    REFERENCES `BattleBotDb`.`Weapon` (`weaponId` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_WeaponEffects_Effect1`
    FOREIGN KEY (`effectId` )
    REFERENCES `BattleBotDb`.`Effect` (`effectId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- null values for the db
insert into BattleBotDb.Armor (armorNameTX,BaseAcInt,dexHinderenceINT,modDT)
values ('No Armor', 0,0,CURRENT_TIMESTAMP());

insert into BattleBotDb.Weapon (weaponNameTX,modDT)
values ('Unarmed',CURRENT_TIMESTAMP());

insert into BattleBotDb.Effect (effectName,modDT)
values ('None',CURRENT_TIMESTAMP())
