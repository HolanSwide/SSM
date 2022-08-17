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
drop table if exists `file`;

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
    `born` varchar(32)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table `file` (
  `fid` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `url` varchar(128) not null,
  `uid` int unsigned not null,
  `filename` varchar(32) not null ,
  `describe` varchar(512),
  `type` varchar(12),
  `memory` varchar(12)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

drop table if exists `rights`;

create table `rights` (
    `rid` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `uid` int unsigned,
    `code` varchar(256),
    `type` int unsigned default '3'
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user`(`username`,`password`) VALUES('admin','123456');
INSERT INTO `user`(`username`,`password`) VALUES('Shinji','123456');
insert into `user_info`(`uid`,`phone`,`email`,`sex`,`born`)
    values (1,'12100001111','admin@local.com',1,'2002-07-27');
insert into `user_info`(`uid`,`phone`,`email`,`sex`,`born`)
    values (2,'12311111111','shinji@eva.com',1,'2002-06-06');

insert into `rights`(uid, code, type) values (1,'ADMIN',0);
insert into rights (uid, code, type)
values (2,'MANAGER',1);

select * from user_info ;