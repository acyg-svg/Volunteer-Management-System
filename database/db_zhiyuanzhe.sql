/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_expressprint

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-11-21 11:30:01
*/


CREATE DATABASE db_ExpressPrint;
USE db_ExpressPrint;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_receivesendmessage`
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `Telephone` varchar(30) DEFAULT NULL,
  `dizhi` varchar(30) DEFAULT NULL,
  `shouji` varchar(100) DEFAULT NULL,
  `QQ` varchar(10) DEFAULT NULL,
  `Name1` varchar(20) DEFAULT NULL,
  `Telephone2` varchar(30) DEFAULT NULL,
  `dizhi1` varchar(30) DEFAULT NULL,
  `receiveAddress` varchar(100) DEFAULT NULL,
  `QQ2` varchar(10) DEFAULT NULL,
  `burn` varchar(200) DEFAULT NULL,
  `xinbie` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ();
INSERT INTO `tb_message` VALUES ();

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------   
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '1', '1');
INSERT INTO `tb_user` VALUES ('2', '2', '2');
