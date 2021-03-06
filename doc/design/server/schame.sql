-- MySQL Script generated by MySQL Workbench
-- 11/05/15 22:32:37
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tourism
-- -----------------------------------------------------
-- 旅游

-- -----------------------------------------------------
-- Schema tourism
--
-- 旅游
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tourism` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `tourism` ;

-- -----------------------------------------------------
-- Table `tourism`.`c_area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tourism`.`c_area` ;

CREATE TABLE IF NOT EXISTS `tourism`.`c_area` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `full_name` LONGTEXT NOT NULL COMMENT '',
  `sort` INT(3) NULL COMMENT '排序 越大优先级越高',
  `parent` BIGINT(20) NULL COMMENT '',
  `tree_path` VARCHAR(255) NULL COMMENT '树路径\n                                    1(,)\n                          2(,1,)         3(,1,)\n                   4(,1,2,)                   5(,1,3,)',
  `created` TIMESTAMP NULL COMMENT '',
  `modified` TIMESTAMP NULL COMMENT '',
  `description` VARCHAR(255) NULL COMMENT '关于旅游城市的描述',
  `star` INT(5) NULL DEFAULT 0 COMMENT '星级， 达到固定星级的应该在默认选择页面上 出现热门城市',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_AREA_PARENT_idx` (`parent` ASC)  COMMENT '',
  CONSTRAINT `FK_AREA_PARENT`
    FOREIGN KEY (`parent`)
    REFERENCES `tourism`.`c_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tourism`.`c_view_spot`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tourism`.`c_view_spot` ;

CREATE TABLE IF NOT EXISTS `tourism`.`c_view_spot` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(255) NULL COMMENT '景点名',
  `picture` VARCHAR(255) NULL COMMENT '',
  `area` BIGINT(20) NOT NULL COMMENT '',
  `title` VARCHAR(50) NOT NULL COMMENT '',
  `description` VARCHAR(255) NULL COMMENT '',
  `parent` BIGINT(20) NULL COMMENT '',
  `clicked` INT(10) NULL DEFAULT 0 COMMENT '点击数（热度）',
  `star` INT(5) NULL DEFAULT 0 COMMENT '星级（名气）',
  `longitude` FLOAT NULL COMMENT '经度',
  `latitude` FLOAT NULL COMMENT '纬度',
  `created` TIMESTAMP NULL COMMENT '',
  `modified` TIMESTAMP NULL COMMENT '',
  `visit_start_time` TIME NULL COMMENT '可参观开始时间',
  `visit_end_time` TIME NULL COMMENT '可参观截止时间',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_VS_PARENT_idx` (`parent` ASC)  COMMENT '',
  CONSTRAINT `FK_VS_PARENT`
    FOREIGN KEY (`parent`)
    REFERENCES `tourism`.`c_view_spot` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '旅游景点';


-- -----------------------------------------------------
-- Table `tourism`.`c_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tourism`.`c_user` ;

CREATE TABLE IF NOT EXISTS `tourism`.`c_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `login_name` VARCHAR(20) NOT NULL COMMENT '',
  `password` VARCHAR(100) NOT NULL COMMENT '',
  `salt` VARCHAR(45) NULL COMMENT '',
  `mobile` VARCHAR(18) NULL COMMENT '',
  `sex` BIT NULL DEFAULT b'1' COMMENT '',
  `nick_name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
COMMENT = '用户';


-- -----------------------------------------------------
-- Table `tourism`.`c_trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tourism`.`c_trip` ;

CREATE TABLE IF NOT EXISTS `tourism`.`c_trip` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `start_date` TIMESTAMP NULL COMMENT '行程开始日期',
  `end_date` TIMESTAMP NULL COMMENT '行程结束日期',
  `user` BIGINT(20) NULL COMMENT '',
  `created` TIMESTAMP NULL COMMENT '',
  `modified` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_TR_USER_idx` (`user` ASC)  COMMENT '',
  CONSTRAINT `FK_TR_USER`
    FOREIGN KEY (`user`)
    REFERENCES `tourism`.`c_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '行程';


-- -----------------------------------------------------
-- Table `tourism`.`c_trip_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tourism`.`c_trip_item` ;

CREATE TABLE IF NOT EXISTS `tourism`.`c_trip_item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `trip` BIGINT(20) NULL COMMENT '行程',
  `view_spot` BIGINT(20) NULL COMMENT '景点',
  `sort` INT(5) NULL COMMENT '',
  `trip_date` TIMESTAMP NULL COMMENT '行程日期',
  `type` INT(5) NULL COMMENT '类型 1 景点 2 酒店 3 饭店',
  `created` TIMESTAMP NULL COMMENT '',
  `modified` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_TI__idx` (`trip` ASC)  COMMENT '',
  INDEX `FK_TI__idx1` (`view_spot` ASC)  COMMENT '',
  CONSTRAINT `FK_TI_TRIP`
    FOREIGN KEY (`trip`)
    REFERENCES `tourism`.`c_trip` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TI_VIEW_SPOT`
    FOREIGN KEY (`view_spot`)
    REFERENCES `tourism`.`c_trip` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '行程清单';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
