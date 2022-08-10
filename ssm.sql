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
drop table if exists `user_info`;

CREATE TABLE `user` (
	`uid` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL DEFAULT 'AYANAMI REI',
	`password` VARCHAR(255) NOT NULL DEFAULT '00000000'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE table `user_info` (
    `mark` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `uid` int unsigned not null,
    `phone` varchar(20),
    `email` varchar(32),
    `sex` int,
    `born` varchar(32),
    foreign key (`uid`) references user(`uid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user`(`username`,`password`) VALUES('admin','123456');
INSERT INTO `user`(`username`,`password`) VALUES('Shinji','123456');
insert into `user_info`(`uid`,`phone`,`email`,`sex`,`born`)
    values (1,'12100001111','admin@local.com',1,'2002-07-27');
insert into `user_info`(`uid`,`phone`,`email`,`sex`,`born`)
    values (2,'12311111111','shinji@eva.com',1,'2002-06-06');

select * from user_info where sex = '1';