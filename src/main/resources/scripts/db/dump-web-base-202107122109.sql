-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: web-base
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `content` varchar(60) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES ('8058626696101265408','2021-03-12 16:08:59.664','2021-03-12 16:09:27.870','7888631140367998976','7888631140367998976','hi','2啊',1,'222草2122啊22112啊'),('8091540653978714112','2021-06-11 11:57:18.734',NULL,'','','weq','saaww',0,''),('8091541221039177728','2021-06-11 11:59:34.001',NULL,'','','rtt','eee',0,''),('8091623143410008064','2021-06-11 17:25:05.788',NULL,'','','信息需','eee',0,''),('8091624957449633792','2021-06-11 17:32:18.287',NULL,'','','信息需','eee',0,'');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_info`
--

DROP TABLE IF EXISTS `file_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_info` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `file_key` varchar(100) DEFAULT NULL,
  `file_md5` varchar(100) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXpp1eo396kmw6naht773ahtg31` (`file_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_info`
--

LOCK TABLES `file_info` WRITE;
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `online_log`
--

DROP TABLE IF EXISTS `online_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `online_log` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `token` varchar(255) NOT NULL COMMENT 'token',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户ID',
  `ip_addr` varchar(40) DEFAULT NULL COMMENT '登录IP地址',
  `browser` varchar(100) DEFAULT NULL COMMENT '浏览器类型',
  `os` varchar(100) DEFAULT NULL COMMENT '操作系统',
  `login_time` datetime(3) DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_log`
--

LOCK TABLES `online_log` WRITE;
/*!40000 ALTER TABLE `online_log` DISABLE KEYS */;
INSERT INTO `online_log` VALUES ('8081102188409028608','2021-05-13 16:38:34.602',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDIzMTQsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.hyEjh6_oX4g0QxleZ9zYTxk5odjYNeldPL2WrU5VWYM','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 16:38:34.602'),('8081105678917206016','2021-05-13 16:52:26.851',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDMxNDYsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.Eg5I4GM4WArbrdinBJk0lR2G-01GkhScLEYHURQL1ms','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 16:52:26.804'),('8081105801646735360','2021-05-13 16:52:56.066',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDMxNzYsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.Ui5UnMe-nVhkOeOa5LL6vUnIIUQoBwEs1k-4Kd8HDXc','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 16:52:56.065'),('8081108339572375552','2021-05-13 17:03:01.226',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDM3ODEsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.cPuJwirkopayQKTkhtkBEgAXo-FwX2yrAygWS2yoywY','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:03:01.153'),('8081108629679800320','2021-05-13 17:04:10.320',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDM4NTAsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.RNCPjHE5H4z4wcYTgKAx_SSUU2R4Ye47qgV9P6-fo34','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:04:10.320'),('8081109098685825024','2021-05-13 17:06:02.186',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDM5NjIsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.Rt6c_KVRz-a60-0IiofF9cjEYRwCNcDEgXO77kSn-z0','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:06:02.140'),('8081111028593623040','2021-05-13 17:13:42.315',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDQ0MjIsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.ba_fNO9in9DAFkMZfEykIqS84G8CNA9wVHvFU0xbMnM','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:13:42.266'),('8081111316965130240','2021-05-13 17:14:51.062',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDQ0OTAsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.5NobonYqkc6dFUK5k61L7AC00dGKn1RDPm3Gaadx9UU','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:14:51.019'),('8081111955124289536','2021-05-13 17:17:23.214',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDQ2NDMsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.rASg0BPb5qccKyr9emwdWcTqjpTw_GR9P8B23l_UqCQ','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:17:23.168'),('8081112319001133056','2021-05-13 17:18:49.924',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDQ3MjksInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.Bm-0wd_ywHh8o0AUGtKQA7_VErj9O9WntS2l7hnCov4','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:18:49.923'),('8081112425481928704','2021-05-13 17:19:15.311',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDQ3NTUsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.ebaLHJwz522cEmjMwgdgQwbZoEAps1ChkvO-Ozw0tgQ','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:19:15.310'),('8081119903819530240','2021-05-13 17:48:58.353',NULL,'7888631140367998976',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjA5MDY1MzgsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.0mqRSRfEwZm6LNHURs_NWKV9Sv15wi6AViqMTix4WS8','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-13 17:48:58.285'),('8083981892699324416','2021-05-21 15:21:29.617',NULL,'7888631140367998976',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjE1ODg4ODksInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.Ye8JFOtmSJN5-aQ-iW6WrSVMUSsI-Hyf_RqmRz7Mv9c','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-05-21 15:21:29.607'),('8091540361006579712','2021-06-11 11:56:08.892',NULL,'7888631140367998976',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjMzOTA5NjgsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.GnAWA_61l2sJXOh_JT8kyIQxURqaSlCnX-gc-5KMxuI','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-06-11 11:56:08.881'),('8098424705164279808','2021-06-30 11:52:04.444',NULL,'7888631140367998976',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjUwMzIzMjQsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.WgkhG-uGxde0JQg-E6Bdz7irZqCabFiZvElNdDAIyVo','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-06-30 11:52:04.433'),('8098425252130881536','2021-06-30 11:54:14.841',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjUwMzI0NTQsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.W3_b_oUpP8sC_9_ySKpRWLvlVojZ3_jHP0vU2OA2LXc','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-06-30 11:54:14.840'),('8098425307751546880','2021-06-30 11:54:28.102',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjUwMzI0NjgsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.kCtMiC3UjwuLbru9wwJ8Z3MtE-NLRiGI4OiPQDD_1do','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-06-30 11:54:28.101'),('8098425546914955264','2021-06-30 11:55:25.123',NULL,NULL,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjUwMzI1MjUsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.nakH4Jab-qKp7TihG6WH7_6j3KpOdvE1AyHbqLSjrOQ','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-06-30 11:55:25.122'),('8099504276995391488','2021-07-03 11:21:54.427',NULL,'7888631140367998976',NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjUyODk3MTQsInVzZXJJZCI6Ijc4ODg2MzExNDAzNjc5OTg5NzYiLCJ1c2VybmFtZSI6ImFkbWluIn0.qX0VQ8xZtlCt5bUKi7mJwNIaPe-qk360ZOYPOvjJZk0','7888631140367998976',NULL,'169.254.172.222',NULL,'2021-07-03 11:21:54.415');
/*!40000 ALTER TABLE `online_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_category`
--

DROP TABLE IF EXISTS `sys_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_category` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(40) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UN_category_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_category`
--

LOCK TABLES `sys_category` WRITE;
/*!40000 ALTER TABLE `sys_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `dept_code` varchar(40) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `parent_id` varchar(40) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_data` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `can_default` int(11) DEFAULT NULL,
  `code` varchar(60) DEFAULT NULL,
  `dict_type` varchar(60) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXn3srd5mph81w0qheoebckvetr` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_type` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `code` varchar(60) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX6qd2ipg7g5ageruvx2bcrbjgy` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_notice` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `notice_type` varchar(255) DEFAULT NULL COMMENT '公告类型 ',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `read_flag` bit(1) DEFAULT NULL COMMENT '阅读状态',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `source_type` varchar(255) DEFAULT NULL COMMENT '来源类型',
  `send_time` datetime(3) DEFAULT NULL COMMENT '发布时间',
  `relative_id` varchar(255) DEFAULT NULL COMMENT '关联业务ID',
  `sender` varchar(255) DEFAULT NULL COMMENT '发布人',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人',
  `dept_id` varchar(255) DEFAULT NULL COMMENT '所属部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operation_log`
--

DROP TABLE IF EXISTS `sys_operation_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_operation_log` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '系统模块',
  `operation_type` int(11) DEFAULT NULL COMMENT '操作类型',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `request_method` varchar(255) DEFAULT NULL COMMENT '请求方式',
  `oper_user_id` varchar(255) DEFAULT NULL COMMENT '操作人员',
  `dept_id` varchar(255) DEFAULT NULL COMMENT '所属部门',
  `oper_url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `oper_ip` varchar(255) DEFAULT NULL COMMENT '请求IP',
  `oper_location` varchar(255) DEFAULT NULL COMMENT '操作地点（暂不展示）',
  `oper_param` text COMMENT '请求参数',
  `json_result` text COMMENT '返回参数',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `error_msg` varchar(2000) DEFAULT NULL COMMENT '错误消息',
  `oper_time` datetime(3) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operation_log`
--

LOCK TABLES `sys_operation_log` WRITE;
/*!40000 ALTER TABLE `sys_operation_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_operation_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `code` varchar(40) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `menu_type` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `parent_id` varchar(40) DEFAULT NULL,
  `sort_no` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `app_code` varchar(40) DEFAULT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `internal_or_external` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES ('7890118016226664448','2019-12-03 02:15:39.000','2019-12-31 03:57:54.000','admin','admin','system','layouts/RouteView','','setting','0','系统管理','',99,0,'/system','TenantBasedate',NULL,NULL),('7890121496970502144','2019-12-03 02:29:29.000','2020-01-03 06:31:29.907','admin','admin','system:user','system/UserList','','','1','用户管理','7890118016226664448',1,0,'/system/user','TenantBasedate',NULL,NULL),('7897654850737954816','2019-12-23 21:24:21.000','2019-12-31 06:57:25.000','admin','admin','index','merck/ImportExcel','','dashboard','0','首页','',1,0,'/merck/importExcel',NULL,NULL,NULL),('7898713051002765312','2019-12-27 01:29:15.000','2019-12-30 03:03:48.322','admin','admin','system:permission','system/NewPermissionList',NULL,'','1','菜单管理','7890118016226664448',2,0,'/system/permission','TenantBasedate',NULL,NULL),('7898714668649349120','2019-12-27 01:35:41.000','2019-12-30 03:04:11.884','admin','admin','system:role','system/RoleList',NULL,NULL,'1','角色管理','7890118016226664448',3,0,'/system/role','TenantBasedate',NULL,NULL),('7898715632005480448','2019-12-27 01:39:30.000','2019-12-30 03:04:25.504','admin','admin','system:category','system/SysCategoryList',NULL,NULL,'1','分类字典','7890118016226664448',4,0,'/system/category','TenantBasedate',NULL,NULL),('7898715932212789248','2019-12-27 01:40:42.000','2019-12-30 03:04:51.098','admin','admin','system:dict','system/DictList',NULL,NULL,'1','数据字典','7890118016226664448',5,0,'/system/dict','TenantBasedate',NULL,NULL),('7946375848045772800','2020-05-06 22:04:11.000','2020-05-06 22:04:43.000','admin','admin','system:DepartList','system/DepartList2',NULL,NULL,'1','部门管理','7890118016226664448',6,0,'/system/DepartList',NULL,NULL,_binary ''),('7946376321171652608','2020-05-06 22:06:04.768',NULL,'admin',NULL,'system:OperationLog','system/OperationLog',NULL,NULL,'1','日志管理','7890118016226664448',7,0,'/system/OperationLog',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `code` varchar(40) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tenant_code` varchar(40) DEFAULT NULL,
  `data_scope` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission_mapping`
--

DROP TABLE IF EXISTS `sys_role_permission_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission_mapping` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `permission_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission_mapping`
--

LOCK TABLES `sys_role_permission_mapping` WRITE;
/*!40000 ALTER TABLE `sys_role_permission_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_permission_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(120) DEFAULT NULL,
  `org_code` varchar(40) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(120) DEFAULT NULL,
  `work_no` varchar(40) DEFAULT NULL,
  `tenant_code` varchar(40) DEFAULT NULL,
  `dept_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXepp4ys4ce7w860c21fiyo4j01` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('7888631140367998976','2019-11-28 23:47:20.000','2020-01-07 06:45:06.000','jjh','admin','static/c138501b-16eb-46bc-884c-c170e04f309d.jpg','2020-01-08 00:00:00','1278822@163.com','admin','','a0d3ddb8c2e90528b2f96b98f8fde73f9b308e6c3db878d5a41342238d30f108','18727723333','1575006440841',1,0,'admin','1412',NULL,NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role_mapping`
--

DROP TABLE IF EXISTS `sys_user_role_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role_mapping` (
  `id` varchar(40) NOT NULL,
  `create_time` datetime(3) DEFAULT NULL,
  `update_time` datetime(3) DEFAULT NULL,
  `create_by` varchar(40) DEFAULT NULL,
  `update_by` varchar(40) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role_mapping`
--

LOCK TABLES `sys_user_role_mapping` WRITE;
/*!40000 ALTER TABLE `sys_user_role_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_role_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'web-base'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-12 21:09:31
