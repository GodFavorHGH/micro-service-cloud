drop database if exists paymentdb;
create database paymentdb;
use paymentdb;
drop table if exists payment;
create table payment(
    id bigint(20) not null auto_increment comment 'id',
    serial varchar(200) default '',
    primary key(id)
);

Create Table: CREATE TABLE `payment` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
     `serial` varchar(200) DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
