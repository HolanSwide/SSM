#########################################################
#
# HolanSwide
# Database name: SSM
# Table:
#	user
#
#
#########################################################

DROP DATABASE IF EXISTS `ssm`;

CREATE DATABASE `ssm`;

USE `ssm`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`uid` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL DEFAULT 'AYANAMI REI',
	`password` VARCHAR(255) NOT NULL DEFAULT '00000000'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user`(`username`,`password`) VALUES('admin','123456');
INSERT INTO `user`(`username`,`password`) VALUES('Shinji','123456');
