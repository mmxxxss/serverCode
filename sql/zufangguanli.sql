-- MySQL dump 10.13  Distrib 5.7.44, for Linux (x86_64)
--
-- Host: localhost    Database: zufangguanli
-- ------------------------------------------------------
-- Server version	5.7.44

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
-- Current Database: `zufangguanli`
--

/*!40000 DROP DATABASE IF EXISTS `zufangguanli`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `zufangguanli` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `zufangguanli`;

--
-- Table structure for table `aboutus`
--

DROP TABLE IF EXISTS `aboutus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aboutus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `subtitle` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '副标题',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `picture1` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片1',
  `picture2` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片2',
  `picture3` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发展历程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aboutus`
--

LOCK TABLES `aboutus` WRITE;
/*!40000 ALTER TABLE `aboutus` DISABLE KEYS */;
INSERT INTO `aboutus` VALUES (1,'2025-04-27 08:09:22','发展历程','DEVELOPMENT HISTORY','山川如画，水光潋滟。在这美丽的自然世界里，我们不禁沉醉于那迷人的风景。春天，花儿盛开，绿树成荫，仿佛置身于童话之中\n；夏天，阳光明媚，海风拂面，让人心旷神怡；秋天，枫叶满山，金色的稻田波光粼粼，令人流连忘返。','file/aboutusPicture1.jpg','file/aboutusPicture2.jpg','file/aboutusPicture3.jpg');
/*!40000 ALTER TABLE `aboutus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `value` longtext COLLATE utf8mb4_unicode_ci COMMENT '值',
  `url` longtext COLLATE utf8mb4_unicode_ci COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'2025-04-27 08:09:22','swiper1','file/swiperPicture1.jpg',NULL),(2,'2025-04-27 08:09:22','swiper2','file/swiperPicture2.jpg',NULL),(3,'2025-04-27 08:09:22','swiper3','file/swiperPicture3.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussfangyuanxinxi`
--

DROP TABLE IF EXISTS `discussfangyuanxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussfangyuanxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房源信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussfangyuanxinxi`
--

LOCK TABLES `discussfangyuanxinxi` WRITE;
/*!40000 ALTER TABLE `discussfangyuanxinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussfangyuanxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangdong`
--

DROP TABLE IF EXISTS `fangdong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangdong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangdong` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房东',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `fangdongxingming` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房东姓名',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `youxiang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fangdong` (`fangdong`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房东';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangdong`
--

LOCK TABLES `fangdong` WRITE;
/*!40000 ALTER TABLE `fangdong` DISABLE KEYS */;
INSERT INTO `fangdong` VALUES (81,'2025-04-27 08:09:22','房东1','123456','房东姓名1','男','file/fangdongTouxiang1.jpg',1,'19819881111','102020001@qq.com'),(82,'2025-04-27 08:09:22','房东2','123456','房东姓名2','男','file/fangdongTouxiang2.jpg',2,'19819881112','102020002@qq.com'),(83,'2025-04-27 08:09:22','房东3','123456','房东姓名3','男','file/fangdongTouxiang3.jpg',3,'19819881113','102020003@qq.com'),(84,'2025-04-27 08:09:22','房东4','123456','房东姓名4','男','file/fangdongTouxiang4.jpg',4,'19819881114','102020004@qq.com'),(85,'2025-04-27 08:09:22','房东5','123456','房东姓名5','男','file/fangdongTouxiang5.jpg',5,'19819881115','102020005@qq.com'),(86,'2025-04-27 08:09:22','房东6','123456','房东姓名6','男','file/fangdongTouxiang6.jpg',6,'19819881116','102020006@qq.com'),(87,'2025-04-27 08:09:22','房东7','123456','房东姓名7','男','file/fangdongTouxiang7.jpg',7,'19819881117','102020007@qq.com'),(88,'2025-04-27 08:09:22','房东8','123456','房东姓名8','男','file/fangdongTouxiang8.jpg',8,'19819881118','102020008@qq.com'),(89,'2025-04-27 08:09:22','房东9','123456','房东姓名9','男','file/fangdongTouxiang9.jpg',9,'19819881119','102020009@qq.com'),(90,'2025-04-27 08:09:22','房东10','123456','房东姓名10','男','file/fangdongTouxiang10.jpg',10,'198198811110','1020200010@qq.com');
/*!40000 ALTER TABLE `fangdong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangdongshensu`
--

DROP TABLE IF EXISTS `fangdongshensu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangdongshensu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '房屋图片',
  `fangwumianji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋面积/m3',
  `fangwudizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋地址',
  `zulinjiage` double NOT NULL COMMENT '租赁价格',
  `huxing` longtext COLLATE utf8mb4_unicode_ci COMMENT '户型',
  `fangdong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东',
  `fangdongxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东姓名',
  `zukeming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '租客名',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `fangdongshensu` longtext COLLATE utf8mb4_unicode_ci COMMENT '房东申诉',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`),
  KEY `zukeming` (`zukeming`,`xingming`),
  CONSTRAINT `fangdongshensu_ibfk_1` FOREIGN KEY (`zukeming`, `xingming`) REFERENCES `zuke` (`zukeming`, `xingming`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房东申诉';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangdongshensu`
--

LOCK TABLES `fangdongshensu` WRITE;
/*!40000 ALTER TABLE `fangdongshensu` DISABLE KEYS */;
INSERT INTO `fangdongshensu` VALUES (1,'2025-04-27 08:09:22','房屋名称1','file/fangdongshensuFangwutupian1.jpg,file/fangdongshensuFangwutupian2.jpg,file/fangdongshensuFangwutupian3.jpg','房屋面积/m31','房屋地址1',1,'file/fangdongshensuHuxing1.jpg,file/fangdongshensuHuxing2.jpg,file/fangdongshensuHuxing3.jpg','房东1','房东姓名1','租客名1','姓名1','房东申诉1',''),(2,'2025-04-27 08:09:22','房屋名称2','file/fangdongshensuFangwutupian2.jpg,file/fangdongshensuFangwutupian3.jpg,file/fangdongshensuFangwutupian4.jpg','房屋面积/m32','房屋地址2',2,'file/fangdongshensuHuxing2.jpg,file/fangdongshensuHuxing3.jpg,file/fangdongshensuHuxing4.jpg','房东2','房东姓名2','租客名2','姓名2','房东申诉2',''),(3,'2025-04-27 08:09:22','房屋名称3','file/fangdongshensuFangwutupian3.jpg,file/fangdongshensuFangwutupian4.jpg,file/fangdongshensuFangwutupian5.jpg','房屋面积/m33','房屋地址3',3,'file/fangdongshensuHuxing3.jpg,file/fangdongshensuHuxing4.jpg,file/fangdongshensuHuxing5.jpg','房东3','房东姓名3','租客名3','姓名3','房东申诉3',''),(4,'2025-04-27 08:09:22','房屋名称4','file/fangdongshensuFangwutupian4.jpg,file/fangdongshensuFangwutupian5.jpg,file/fangdongshensuFangwutupian6.jpg','房屋面积/m34','房屋地址4',4,'file/fangdongshensuHuxing4.jpg,file/fangdongshensuHuxing5.jpg,file/fangdongshensuHuxing6.jpg','房东4','房东姓名4','租客名4','姓名4','房东申诉4',''),(5,'2025-04-27 08:09:22','房屋名称5','file/fangdongshensuFangwutupian5.jpg,file/fangdongshensuFangwutupian6.jpg,file/fangdongshensuFangwutupian7.jpg','房屋面积/m35','房屋地址5',5,'file/fangdongshensuHuxing5.jpg,file/fangdongshensuHuxing6.jpg,file/fangdongshensuHuxing7.jpg','房东5','房东姓名5','租客名5','姓名5','房东申诉5',''),(6,'2025-04-27 08:09:22','房屋名称6','file/fangdongshensuFangwutupian6.jpg,file/fangdongshensuFangwutupian7.jpg,file/fangdongshensuFangwutupian8.jpg','房屋面积/m36','房屋地址6',6,'file/fangdongshensuHuxing6.jpg,file/fangdongshensuHuxing7.jpg,file/fangdongshensuHuxing8.jpg','房东6','房东姓名6','租客名6','姓名6','房东申诉6',''),(7,'2025-04-27 08:09:22','房屋名称7','file/fangdongshensuFangwutupian7.jpg,file/fangdongshensuFangwutupian8.jpg,file/fangdongshensuFangwutupian9.jpg','房屋面积/m37','房屋地址7',7,'file/fangdongshensuHuxing7.jpg,file/fangdongshensuHuxing8.jpg,file/fangdongshensuHuxing9.jpg','房东7','房东姓名7','租客名7','姓名7','房东申诉7',''),(8,'2025-04-27 08:09:22','房屋名称8','file/fangdongshensuFangwutupian8.jpg,file/fangdongshensuFangwutupian9.jpg,file/fangdongshensuFangwutupian10.jpg','房屋面积/m38','房屋地址8',8,'file/fangdongshensuHuxing8.jpg,file/fangdongshensuHuxing9.jpg,file/fangdongshensuHuxing10.jpg','房东8','房东姓名8','租客名8','姓名8','房东申诉8',''),(9,'2025-04-27 08:09:22','房屋名称9','file/fangdongshensuFangwutupian9.jpg,file/fangdongshensuFangwutupian10.jpg,file/fangdongshensuFangwutupian11.jpg','房屋面积/m39','房屋地址9',9,'file/fangdongshensuHuxing9.jpg,file/fangdongshensuHuxing10.jpg,file/fangdongshensuHuxing11.jpg','房东9','房东姓名9','租客名9','姓名9','房东申诉9',''),(10,'2025-04-27 08:09:22','房屋名称10','file/fangdongshensuFangwutupian10.jpg,file/fangdongshensuFangwutupian11.jpg,file/fangdongshensuFangwutupian12.jpg','房屋面积/m310','房屋地址10',10,'file/fangdongshensuHuxing10.jpg,file/fangdongshensuHuxing11.jpg,file/fangdongshensuHuxing12.jpg','房东10','房东姓名10','租客名10','姓名10','房东申诉10','');
/*!40000 ALTER TABLE `fangdongshensu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangwuzixun`
--

DROP TABLE IF EXISTS `fangwuzixun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangwuzixun` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `jianjie` longtext COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `tupian` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `neirong` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房屋资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangwuzixun`
--

LOCK TABLES `fangwuzixun` WRITE;
/*!40000 ALTER TABLE `fangwuzixun` DISABLE KEYS */;
INSERT INTO `fangwuzixun` VALUES (1,'2025-04-27 08:09:22','标题1','简介1','file/fangwuzixunTupian1.jpg,file/fangwuzixunTupian2.jpg,file/fangwuzixunTupian3.jpg','内容1','2025-04-27'),(2,'2025-04-27 08:09:22','标题2','简介2','file/fangwuzixunTupian2.jpg,file/fangwuzixunTupian3.jpg,file/fangwuzixunTupian4.jpg','内容2','2025-04-27'),(3,'2025-04-27 08:09:22','标题3','简介3','file/fangwuzixunTupian3.jpg,file/fangwuzixunTupian4.jpg,file/fangwuzixunTupian5.jpg','内容3','2025-04-27'),(4,'2025-04-27 08:09:22','标题4','简介4','file/fangwuzixunTupian4.jpg,file/fangwuzixunTupian5.jpg,file/fangwuzixunTupian6.jpg','内容4','2025-04-27'),(5,'2025-04-27 08:09:22','标题5','简介5','file/fangwuzixunTupian5.jpg,file/fangwuzixunTupian6.jpg,file/fangwuzixunTupian7.jpg','内容5','2025-04-27'),(6,'2025-04-27 08:09:22','标题6','简介6','file/fangwuzixunTupian6.jpg,file/fangwuzixunTupian7.jpg,file/fangwuzixunTupian8.jpg','内容6','2025-04-27'),(7,'2025-04-27 08:09:22','标题7','简介7','file/fangwuzixunTupian7.jpg,file/fangwuzixunTupian8.jpg,file/fangwuzixunTupian9.jpg','内容7','2025-04-27'),(8,'2025-04-27 08:09:22','标题8','简介8','file/fangwuzixunTupian8.jpg,file/fangwuzixunTupian9.jpg,file/fangwuzixunTupian10.jpg','内容8','2025-04-27'),(9,'2025-04-27 08:09:22','标题9','简介9','file/fangwuzixunTupian9.jpg,file/fangwuzixunTupian10.jpg,file/fangwuzixunTupian11.jpg','内容9','2025-04-27'),(10,'2025-04-27 08:09:22','标题10','简介10','file/fangwuzixunTupian10.jpg,file/fangwuzixunTupian11.jpg,file/fangwuzixunTupian12.jpg','内容10','2025-04-27');
/*!40000 ALTER TABLE `fangwuzixun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangwuzulin`
--

DROP TABLE IF EXISTS `fangwuzulin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangwuzulin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '房屋图片',
  `fangwumianji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋面积/m3',
  `fangwudizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋地址',
  `zulinjiage` double NOT NULL COMMENT '租赁价格',
  `huxing` longtext COLLATE utf8mb4_unicode_ci COMMENT '户型',
  `fangdong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东',
  `fangdongxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东姓名',
  `zukeming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '租客名',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `zulinshijian` int(11) DEFAULT NULL COMMENT '租赁/月',
  `zulinrenshu` int(11) DEFAULT NULL COMMENT '租赁人数',
  `zulinjine` double DEFAULT NULL COMMENT '租赁金额',
  `ispay` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '未支付' COMMENT '是否支付',
  `isUsed` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否使用',
  PRIMARY KEY (`id`),
  KEY `zukeming` (`zukeming`,`xingming`),
  CONSTRAINT `fangwuzulin_ibfk_1` FOREIGN KEY (`zukeming`, `xingming`) REFERENCES `zuke` (`zukeming`, `xingming`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房屋租赁';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangwuzulin`
--

LOCK TABLES `fangwuzulin` WRITE;
/*!40000 ALTER TABLE `fangwuzulin` DISABLE KEYS */;
INSERT INTO `fangwuzulin` VALUES (1,'2025-04-27 08:09:22','房屋名称1','file/fangwuzulinFangwutupian1.jpg,file/fangwuzulinFangwutupian2.jpg,file/fangwuzulinFangwutupian3.jpg','房屋面积/m31','房屋地址1',1,'file/fangwuzulinHuxing1.jpg,file/fangwuzulinHuxing2.jpg,file/fangwuzulinHuxing3.jpg','房东1','房东姓名1','租客名1','姓名1',1,1,1,'未支付',NULL,NULL),(2,'2025-04-27 08:09:22','房屋名称2','file/fangwuzulinFangwutupian2.jpg,file/fangwuzulinFangwutupian3.jpg,file/fangwuzulinFangwutupian4.jpg','房屋面积/m32','房屋地址2',2,'file/fangwuzulinHuxing2.jpg,file/fangwuzulinHuxing3.jpg,file/fangwuzulinHuxing4.jpg','房东2','房东姓名2','租客名2','姓名2',2,2,2,'未支付',NULL,NULL),(3,'2025-04-27 08:09:22','房屋名称3','file/fangwuzulinFangwutupian3.jpg,file/fangwuzulinFangwutupian4.jpg,file/fangwuzulinFangwutupian5.jpg','房屋面积/m33','房屋地址3',3,'file/fangwuzulinHuxing3.jpg,file/fangwuzulinHuxing4.jpg,file/fangwuzulinHuxing5.jpg','房东3','房东姓名3','租客名3','姓名3',3,3,3,'未支付',NULL,NULL),(4,'2025-04-27 08:09:22','房屋名称4','file/fangwuzulinFangwutupian4.jpg,file/fangwuzulinFangwutupian5.jpg,file/fangwuzulinFangwutupian6.jpg','房屋面积/m34','房屋地址4',4,'file/fangwuzulinHuxing4.jpg,file/fangwuzulinHuxing5.jpg,file/fangwuzulinHuxing6.jpg','房东4','房东姓名4','租客名4','姓名4',4,4,4,'未支付',NULL,NULL),(5,'2025-04-27 08:09:22','房屋名称5','file/fangwuzulinFangwutupian5.jpg,file/fangwuzulinFangwutupian6.jpg,file/fangwuzulinFangwutupian7.jpg','房屋面积/m35','房屋地址5',5,'file/fangwuzulinHuxing5.jpg,file/fangwuzulinHuxing6.jpg,file/fangwuzulinHuxing7.jpg','房东5','房东姓名5','租客名5','姓名5',5,5,5,'未支付',NULL,NULL),(6,'2025-04-27 08:09:22','房屋名称6','file/fangwuzulinFangwutupian6.jpg,file/fangwuzulinFangwutupian7.jpg,file/fangwuzulinFangwutupian8.jpg','房屋面积/m36','房屋地址6',6,'file/fangwuzulinHuxing6.jpg,file/fangwuzulinHuxing7.jpg,file/fangwuzulinHuxing8.jpg','房东6','房东姓名6','租客名6','姓名6',6,6,6,'未支付',NULL,NULL),(7,'2025-04-27 08:09:22','房屋名称7','file/fangwuzulinFangwutupian7.jpg,file/fangwuzulinFangwutupian8.jpg,file/fangwuzulinFangwutupian9.jpg','房屋面积/m37','房屋地址7',7,'file/fangwuzulinHuxing7.jpg,file/fangwuzulinHuxing8.jpg,file/fangwuzulinHuxing9.jpg','房东7','房东姓名7','租客名7','姓名7',7,7,7,'未支付',NULL,NULL),(8,'2025-04-27 08:09:22','房屋名称8','file/fangwuzulinFangwutupian8.jpg,file/fangwuzulinFangwutupian9.jpg,file/fangwuzulinFangwutupian10.jpg','房屋面积/m38','房屋地址8',8,'file/fangwuzulinHuxing8.jpg,file/fangwuzulinHuxing9.jpg,file/fangwuzulinHuxing10.jpg','房东8','房东姓名8','租客名8','姓名8',8,8,8,'未支付',NULL,NULL),(9,'2025-04-27 08:09:22','房屋名称9','file/fangwuzulinFangwutupian9.jpg,file/fangwuzulinFangwutupian10.jpg,file/fangwuzulinFangwutupian11.jpg','房屋面积/m39','房屋地址9',9,'file/fangwuzulinHuxing9.jpg,file/fangwuzulinHuxing10.jpg,file/fangwuzulinHuxing11.jpg','房东9','房东姓名9','租客名9','姓名9',9,9,9,'未支付',NULL,NULL),(10,'2025-04-27 08:09:22','房屋名称10','file/fangwuzulinFangwutupian10.jpg,file/fangwuzulinFangwutupian11.jpg,file/fangwuzulinFangwutupian12.jpg','房屋面积/m310','房屋地址10',10,'file/fangwuzulinHuxing10.jpg,file/fangwuzulinHuxing11.jpg,file/fangwuzulinHuxing12.jpg','房东10','房东姓名10','租客名10','姓名10',10,10,10,'未支付',NULL,NULL);
/*!40000 ALTER TABLE `fangwuzulin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangyuanxinxi`
--

DROP TABLE IF EXISTS `fangyuanxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fangyuanxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangyuanbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房源编号',
  `fangwumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '房屋图片',
  `fangwumianji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋面积/m3',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `fangwudizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋地址',
  `zulinfangshi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '租赁方式',
  `zulinjiage` double NOT NULL COMMENT '租赁价格',
  `huxing` longtext COLLATE utf8mb4_unicode_ci COMMENT '户型',
  `fangwujieshao` longtext COLLATE utf8mb4_unicode_ci COMMENT '房屋介绍',
  `shifouyourenzulin` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否有人租赁',
  `fangdong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东',
  `fangdongxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东姓名',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `youxiang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `storeup_number` int(11) DEFAULT '0' COMMENT '收藏数',
  `discuss_number` int(11) DEFAULT '0' COMMENT '评论数',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  `fulladdress` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `zulinrenshu` int(11) DEFAULT NULL COMMENT '租赁人数',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房源信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangyuanxinxi`
--

LOCK TABLES `fangyuanxinxi` WRITE;
/*!40000 ALTER TABLE `fangyuanxinxi` DISABLE KEYS */;
INSERT INTO `fangyuanxinxi` VALUES (1,'2025-04-27 08:09:22','房源编号1','房屋名称1','file/fangyuanxinxiFangwutupian1.jpg,file/fangyuanxinxiFangwutupian2.jpg,file/fangyuanxinxiFangwutupian3.jpg','房屋面积/m31','2025-04-27 16:09:22','房屋地址1','整租',1,'file/fangyuanxinxiHuxing1.jpg,file/fangyuanxinxiHuxing2.jpg,file/fangyuanxinxiHuxing3.jpg','房屋介绍1','是','房东1','房东姓名1','19819881111','102020001@qq.com','2025-04-27 16:09:22',1,1,1,1,'宇宙银河系地球1号',1,'是',''),(2,'2025-04-27 08:09:22','房源编号2','房屋名称2','file/fangyuanxinxiFangwutupian2.jpg,file/fangyuanxinxiFangwutupian3.jpg,file/fangyuanxinxiFangwutupian4.jpg','房屋面积/m32','2025-04-27 16:09:22','房屋地址2','整租',2,'file/fangyuanxinxiHuxing2.jpg,file/fangyuanxinxiHuxing3.jpg,file/fangyuanxinxiHuxing4.jpg','房屋介绍2','是','房东2','房东姓名2','19819881112','102020002@qq.com','2025-04-27 16:09:22',2,2,2,2,'宇宙银河系地球2号',2,'是',''),(3,'2025-04-27 08:09:22','房源编号3','房屋名称3','file/fangyuanxinxiFangwutupian3.jpg,file/fangyuanxinxiFangwutupian4.jpg,file/fangyuanxinxiFangwutupian5.jpg','房屋面积/m33','2025-04-27 16:09:22','房屋地址3','整租',3,'file/fangyuanxinxiHuxing3.jpg,file/fangyuanxinxiHuxing4.jpg,file/fangyuanxinxiHuxing5.jpg','房屋介绍3','是','房东3','房东姓名3','19819881113','102020003@qq.com','2025-04-27 16:09:22',3,3,3,3,'宇宙银河系地球3号',3,'是',''),(4,'2025-04-27 08:09:22','房源编号4','房屋名称4','file/fangyuanxinxiFangwutupian4.jpg,file/fangyuanxinxiFangwutupian5.jpg,file/fangyuanxinxiFangwutupian6.jpg','房屋面积/m34','2025-04-27 16:09:22','房屋地址4','整租',4,'file/fangyuanxinxiHuxing4.jpg,file/fangyuanxinxiHuxing5.jpg,file/fangyuanxinxiHuxing6.jpg','房屋介绍4','是','房东4','房东姓名4','19819881114','102020004@qq.com','2025-04-27 16:09:22',4,4,4,4,'宇宙银河系地球4号',4,'是',''),(5,'2025-04-27 08:09:22','房源编号5','房屋名称5','file/fangyuanxinxiFangwutupian5.jpg,file/fangyuanxinxiFangwutupian6.jpg,file/fangyuanxinxiFangwutupian7.jpg','房屋面积/m35','2025-04-27 16:09:22','房屋地址5','整租',5,'file/fangyuanxinxiHuxing5.jpg,file/fangyuanxinxiHuxing6.jpg,file/fangyuanxinxiHuxing7.jpg','房屋介绍5','是','房东5','房东姓名5','19819881115','102020005@qq.com','2025-04-27 16:09:22',5,5,5,5,'宇宙银河系地球5号',5,'是',''),(6,'2025-04-27 08:09:22','房源编号6','房屋名称6','file/fangyuanxinxiFangwutupian6.jpg,file/fangyuanxinxiFangwutupian7.jpg,file/fangyuanxinxiFangwutupian8.jpg','房屋面积/m36','2025-04-27 16:09:22','房屋地址6','整租',6,'file/fangyuanxinxiHuxing6.jpg,file/fangyuanxinxiHuxing7.jpg,file/fangyuanxinxiHuxing8.jpg','房屋介绍6','是','房东6','房东姓名6','19819881116','102020006@qq.com','2025-04-27 16:09:22',6,6,6,6,'宇宙银河系地球6号',6,'是',''),(7,'2025-04-27 08:09:22','房源编号7','房屋名称7','file/fangyuanxinxiFangwutupian7.jpg,file/fangyuanxinxiFangwutupian8.jpg,file/fangyuanxinxiFangwutupian9.jpg','房屋面积/m37','2025-04-27 16:09:22','房屋地址7','整租',7,'file/fangyuanxinxiHuxing7.jpg,file/fangyuanxinxiHuxing8.jpg,file/fangyuanxinxiHuxing9.jpg','房屋介绍7','是','房东7','房东姓名7','19819881117','102020007@qq.com','2025-04-27 16:09:22',7,7,7,7,'宇宙银河系地球7号',7,'是',''),(8,'2025-04-27 08:09:22','房源编号8','房屋名称8','file/fangyuanxinxiFangwutupian8.jpg,file/fangyuanxinxiFangwutupian9.jpg,file/fangyuanxinxiFangwutupian10.jpg','房屋面积/m38','2025-04-27 16:09:22','房屋地址8','整租',8,'file/fangyuanxinxiHuxing8.jpg,file/fangyuanxinxiHuxing9.jpg,file/fangyuanxinxiHuxing10.jpg','房屋介绍8','是','房东8','房东姓名8','19819881118','102020008@qq.com','2025-04-27 16:09:22',8,8,8,8,'宇宙银河系地球8号',8,'是',''),(9,'2025-04-27 08:09:22','房源编号9','房屋名称9','file/fangyuanxinxiFangwutupian9.jpg,file/fangyuanxinxiFangwutupian10.jpg,file/fangyuanxinxiFangwutupian11.jpg','房屋面积/m39','2025-04-27 16:09:22','房屋地址9','整租',9,'file/fangyuanxinxiHuxing9.jpg,file/fangyuanxinxiHuxing10.jpg,file/fangyuanxinxiHuxing11.jpg','房屋介绍9','是','房东9','房东姓名9','19819881119','102020009@qq.com','2025-04-27 16:09:22',9,9,9,9,'宇宙银河系地球9号',9,'是',''),(10,'2025-04-27 08:09:22','房源编号10','房屋名称10','file/fangyuanxinxiFangwutupian10.jpg,file/fangyuanxinxiFangwutupian11.jpg,file/fangyuanxinxiFangwutupian12.jpg','房屋面积/m310','2025-04-27 16:09:22','房屋地址10','整租',10,'file/fangyuanxinxiHuxing10.jpg,file/fangyuanxinxiHuxing11.jpg,file/fangyuanxinxiHuxing12.jpg','房屋介绍10','是','房东10','房东姓名10','198198811110','1020200010@qq.com','2025-04-27 16:09:22',10,10,10,10,'宇宙银河系地球10号',10,'是','');
/*!40000 ALTER TABLE `fangyuanxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2025-04-27 08:09:22','[{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"导出\"],\"appFrontIcon\":\"cuIcon-flashlightopen\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"导出\"],\"classname\":\"fangdong\",\"menu\":\"房东\",\"menuJump\":\"列表\",\"tableName\":\"fangdong\"}],\"fontClass\":\"icon-user5\",\"menu\":\"房东管理\",\"unicode\":\"&#xef9b;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"news\",\"menu\":\"通知公告\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"fontClass\":\"icon-common28\",\"menu\":\"通知公告管理\",\"unicode\":\"&#xee2d;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"导出\"],\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"导出\"],\"classname\":\"zuke\",\"menu\":\"租客\",\"menuJump\":\"列表\",\"tableName\":\"zuke\"}],\"fontClass\":\"icon-user8\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9e;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"查看评论\",\"预约\"],\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"查看评论\",\"审核\"],\"classname\":\"fangyuanxinxi\",\"menu\":\"房源信息\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanxinxi\"}],\"fontClass\":\"icon-common18\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xedff;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"拟定合同\"],\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"classname\":\"yuyuekanfang\",\"menu\":\"预约看房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuekanfang\"}],\"fontClass\":\"icon-common30\",\"menu\":\"预约看房管理\",\"unicode\":\"&#xee30;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"租赁\"],\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"classname\":\"zulinhetong\",\"menu\":\"租赁合同\",\"menuJump\":\"列表\",\"tableName\":\"zulinhetong\"}],\"fontClass\":\"icon-common11\",\"menu\":\"租赁合同管理\",\"unicode\":\"&#xeded;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\",\"申诉\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"classname\":\"fangwuzulin\",\"menu\":\"房屋租赁\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzulin\"}],\"fontClass\":\"icon-common25\",\"menu\":\"房屋租赁管理\",\"unicode\":\"&#xee09;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"appFrontIcon\":\"cuIcon-medal\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"classname\":\"fangdongshensu\",\"menu\":\"房东申诉\",\"menuJump\":\"列表\",\"tableName\":\"fangdongshensu\"}],\"fontClass\":\"icon-common36\",\"menu\":\"房东申诉管理\",\"unicode\":\"&#xee9f;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"查看\",\"修改\"],\"classname\":\"systemintro\",\"menu\":\"网站介绍\",\"menuJump\":\"列表\",\"tableName\":\"systemintro\"}],\"fontClass\":\"icon-common37\",\"menu\":\"网站介绍管理\",\"unicode\":\"&#xeea4;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"users\",\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"}],\"fontClass\":\"icon-user7\",\"menu\":\"管理员管理\",\"unicode\":\"&#xef9d;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\",\"修改\"],\"classname\":\"config\",\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common12\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xedf4;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"回复\"],\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"回复\"],\"classname\":\"messages\",\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"fontClass\":\"icon-common24\",\"menu\":\"留言板管理\",\"unicode\":\"&#xee07;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\",\"修改\"],\"classname\":\"aboutus\",\"menu\":\"发展历程\",\"menuJump\":\"列表\",\"tableName\":\"aboutus\"}],\"fontClass\":\"icon-common37\",\"menu\":\"发展历程管理\",\"unicode\":\"&#xeea4;\"},{\"child\":[{\"allButtons\":[\"菜单管理\"],\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"菜单管理\"],\"classname\":\"menu\",\"menu\":\"菜单\",\"menuJump\":\"列表\",\"tableName\":\"menu\"}],\"fontClass\":\"icon-common26\",\"menu\":\"菜单管理\",\"unicode\":\"&#xee2b;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"fangwuzixun\",\"menu\":\"房屋资讯\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzixun\"}],\"fontClass\":\"icon-common7\",\"menu\":\"房屋资讯管理\",\"unicode\":\"&#xedb4;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"fontClass\":\"icon-common2\",\"menu\":\"通知公告\",\"menuJump\":\"列表\",\"tableName\":\"news\",\"unicode\":\"&#xeda4;\"}],\"fontClass\":\"icon-common2\",\"menu\":\"通知公告管理\",\"unicode\":\"&#xeda4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"fangwuzixun\",\"fontClass\":\"icon-common24\",\"menu\":\"房屋资讯\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzixun\",\"unicode\":\"&#xee07;\"}],\"fontClass\":\"icon-common24\",\"menu\":\"房屋资讯管理\",\"unicode\":\"&#xee07;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\",\"预约\"],\"classname\":\"fangyuanxinxi\",\"fontClass\":\"icon-common3\",\"menu\":\"房源信息\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanxinxi\",\"unicode\":\"&#xeda5;\"}],\"fontClass\":\"icon-common3\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xeda5;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"messages\",\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"pathName\":\"users\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"拟定合同\"],\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"查看\"],\"classname\":\"yuyuekanfang\",\"menu\":\"预约看房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuekanfang\"}],\"fontClass\":\"icon-common30\",\"menu\":\"预约看房管理\",\"unicode\":\"&#xee30;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"租赁\"],\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\",\"租赁\"],\"classname\":\"zulinhetong\",\"menu\":\"租赁合同\",\"menuJump\":\"列表\",\"tableName\":\"zulinhetong\"}],\"fontClass\":\"icon-common11\",\"menu\":\"租赁合同管理\",\"unicode\":\"&#xeded;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\",\"申诉\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"支付\"],\"classname\":\"fangwuzulin\",\"menu\":\"房屋租赁\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzulin\"}],\"fontClass\":\"icon-common25\",\"menu\":\"房屋租赁管理\",\"unicode\":\"&#xee09;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\"],\"classname\":\"storeup\",\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common18\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xedff;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"fontClass\":\"icon-common2\",\"menu\":\"通知公告\",\"menuJump\":\"列表\",\"tableName\":\"news\",\"unicode\":\"&#xeda4;\"}],\"fontClass\":\"icon-common2\",\"menu\":\"通知公告管理\",\"unicode\":\"&#xeda4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"fangwuzixun\",\"fontClass\":\"icon-common24\",\"menu\":\"房屋资讯\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzixun\",\"unicode\":\"&#xee07;\"}],\"fontClass\":\"icon-common24\",\"menu\":\"房屋资讯管理\",\"unicode\":\"&#xee07;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\",\"预约\"],\"classname\":\"fangyuanxinxi\",\"fontClass\":\"icon-common3\",\"menu\":\"房源信息\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanxinxi\",\"unicode\":\"&#xeda5;\"}],\"fontClass\":\"icon-common3\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xeda5;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"messages\",\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"pathName\":\"zuke\",\"roleName\":\"租客\",\"tableName\":\"zuke\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"查看评论\",\"预约\"],\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\",\"查看评论\",\"新增\",\"修改\",\"删除\"],\"classname\":\"fangyuanxinxi\",\"menu\":\"房源信息\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanxinxi\"}],\"fontClass\":\"icon-common18\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xedff;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"拟定合同\"],\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\",\"拟定合同\"],\"classname\":\"yuyuekanfang\",\"menu\":\"预约看房\",\"menuJump\":\"列表\",\"tableName\":\"yuyuekanfang\"}],\"fontClass\":\"icon-common30\",\"menu\":\"预约看房管理\",\"unicode\":\"&#xee30;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"租赁\"],\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"classname\":\"zulinhetong\",\"menu\":\"租赁合同\",\"menuJump\":\"列表\",\"tableName\":\"zulinhetong\"}],\"fontClass\":\"icon-common11\",\"menu\":\"租赁合同管理\",\"unicode\":\"&#xeded;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\",\"申诉\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"申诉\"],\"classname\":\"fangwuzulin\",\"menu\":\"房屋租赁\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzulin\"}],\"fontClass\":\"icon-common25\",\"menu\":\"房屋租赁管理\",\"unicode\":\"&#xee09;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"appFrontIcon\":\"cuIcon-medal\",\"buttons\":[\"查看\"],\"classname\":\"fangdongshensu\",\"menu\":\"房东申诉\",\"menuJump\":\"列表\",\"tableName\":\"fangdongshensu\"}],\"fontClass\":\"icon-common36\",\"menu\":\"房东申诉管理\",\"unicode\":\"&#xee9f;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"fontClass\":\"icon-common2\",\"menu\":\"通知公告\",\"menuJump\":\"列表\",\"tableName\":\"news\",\"unicode\":\"&#xeda4;\"}],\"fontClass\":\"icon-common2\",\"menu\":\"通知公告管理\",\"unicode\":\"&#xeda4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"fangwuzixun\",\"fontClass\":\"icon-common24\",\"menu\":\"房屋资讯\",\"menuJump\":\"列表\",\"tableName\":\"fangwuzixun\",\"unicode\":\"&#xee07;\"}],\"fontClass\":\"icon-common24\",\"menu\":\"房屋资讯管理\",\"unicode\":\"&#xee07;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\",\"预约\"],\"classname\":\"fangyuanxinxi\",\"fontClass\":\"icon-common3\",\"menu\":\"房源信息\",\"menuJump\":\"列表\",\"tableName\":\"fangyuanxinxi\",\"unicode\":\"&#xeda5;\"}],\"fontClass\":\"icon-common3\",\"menu\":\"房源信息管理\",\"unicode\":\"&#xeda5;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"messages\",\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"pathName\":\"fangdong\",\"roleName\":\"房东\",\"tableName\":\"fangdong\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '留言人id',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '留言内容',
  `cpicture` longtext COLLATE utf8mb4_unicode_ci COMMENT '留言图片',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `rpicture` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='留言板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'2025-04-27 08:09:22',1,'用户名1','file/messagesAvatarurl1.jpg','留言内容1','file/messagesCpicture1.jpg','回复内容1','file/messagesRpicture1.jpg'),(2,'2025-04-27 08:09:22',2,'用户名2','file/messagesAvatarurl2.jpg','留言内容2','file/messagesCpicture2.jpg','回复内容2','file/messagesRpicture2.jpg'),(3,'2025-04-27 08:09:22',3,'用户名3','file/messagesAvatarurl3.jpg','留言内容3','file/messagesCpicture3.jpg','回复内容3','file/messagesRpicture3.jpg'),(4,'2025-04-27 08:09:22',4,'用户名4','file/messagesAvatarurl4.jpg','留言内容4','file/messagesCpicture4.jpg','回复内容4','file/messagesRpicture4.jpg'),(5,'2025-04-27 08:09:22',5,'用户名5','file/messagesAvatarurl5.jpg','留言内容5','file/messagesCpicture5.jpg','回复内容5','file/messagesRpicture5.jpg'),(6,'2025-04-27 08:09:22',6,'用户名6','file/messagesAvatarurl6.jpg','留言内容6','file/messagesCpicture6.jpg','回复内容6','file/messagesRpicture6.jpg'),(7,'2025-04-27 08:09:22',7,'用户名7','file/messagesAvatarurl7.jpg','留言内容7','file/messagesCpicture7.jpg','回复内容7','file/messagesRpicture7.jpg'),(8,'2025-04-27 08:09:22',8,'用户名8','file/messagesAvatarurl8.jpg','留言内容8','file/messagesCpicture8.jpg','回复内容8','file/messagesRpicture8.jpg'),(9,'2025-04-27 08:09:22',9,'用户名9','file/messagesAvatarurl9.jpg','留言内容9','file/messagesCpicture9.jpg','回复内容9','file/messagesRpicture9.jpg'),(10,'2025-04-27 08:09:22',10,'用户名10','file/messagesAvatarurl10.jpg','留言内容10','file/messagesCpicture10.jpg','回复内容10','file/messagesRpicture10.jpg');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='通知公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'2025-04-27 08:09:22','余生，愿你活出自己的精彩','曾几何时，为了让自己显得合群，选择去做自己不喜欢的事;为了讨好喜欢的人，一次次地委屈自己;甚至，为了陌生人的一个眼神，就陷入了深深的自我怀疑。','file/newsPicture1.jpg','可是，这样小心翼翼的你，一定很累吧。你以为照顾了所有人的想法，就能得到他们的喜欢;你以为逼着自己合群，就能真的合群。直到后来才发现，在日复一日对自己的为难中，你逐渐弄丢了真实的自己.\n殊不知，人生在世，最不值得的事情，就是在别人的眼光中，迷失自己。其实，正如世界上没有十全十美的人，你也同样无法做到让每个人满意。\n世上没有不快乐的人，只有不肯让自己快乐的心。有一句话说:\n如果一段关系让你变得卑微，你可以选择抽身离去;如果一个人总是让你悲伤哭泣，你要学会放手。\n始终相信，每个人最初的样子，都是最美好的。真正喜欢你的人，会喜欢你原来的样子:真正爱你的从来不需要你的委曲求全。\n后半生，请把身上的枷锁，全部解除。去做喜欢的事，去听自己内心的声音。你会发现，这世上没有什么事情比活出自己更加幸福。\n要相信，真实的自己亦是一道风景线。你若盛开，清风自来。愿你此生尽兴，不负韶华，'),(2,'2025-04-27 08:09:22','岁月无常，好好珍惜','常听到这样的话，如果一切可以重新开始，我一定改掉任性，学会坚持，如果有下辈子，我一定好好珍惜，不会再弄丢原本属于自己的幸福。','file/newsPicture2.jpg','然而，世上有很多事情没有再来一次的机会，一旦错失就意味着无法弥补，正如人与人之间，有的只是一世的缘分，一旦转身，就意味着再无可能。\n这一生只活一次，有些人也只爱一回。\n所以，在拥有时就好好把握，对于来世，可以适当憧憬，但不要一昧去幻想，活着，唯有珍惜身边做好眼前事，才能让明天少一些遗憾。人，\n既然有幸来到这个世上，那就要努力把这辈子活好。岁月其实远没有想象中的那么漫长，若是能爱就好好爱，别让说好相伴一生的人，中途散走;若是当下能相知相守，就别去等待虚无缥缈的未来。\n就像一位网友留言说的:我从来不去期待下辈子，我要的只有今生，世事无常，来世是怎样的光景，谁都无法预知。对我来说，在有限的时光里，善待爱自己及自己爱的人，用心珍惜相聚的每一时刻，努力过好当下就足够了。\n时光匆匆，韶华似水，每个人都只有这短暂的一生。\n有些事，如果喜欢就坚定努力的去做，有些人，如果爱就真诚用心地去爱，别幻想着重来，别总是寄希望于下辈子。\n下辈子，彼此也许再也不会遇见，就算遇见了，谁还会记得谁，今生相互承诺的两个人，来生也许相见不相识。\n想起之前看过的一句话:人生没有假如，我们没有来世，下辈子，你我也许只是大千世界里互不相识的两个陌生人。\n的确，生命只有一次，今生有幸相遇的人，下辈子不一定能遇见，就算能遇见，谁能把谁陪伴，谁又是谁的谁?\n余生不长，趁着岁月未老，好好珍惜这辈子的缘分吧，别等到失去了才悔不该当初。'),(3,'2025-04-27 08:09:22','与其背着烦恼活，不如带着美好过','一直觉得，感情里，无疾而终并不可怕，可怕的是结束后，你还抱着回忆不肯放;岁月中，失去并不可怕，可怕的是失去后，你还揪着曾经不肯忘。\n有些事，明知道不应该继续，却始终没有转身的勇气;有些人，明知道已经成为过去，却还是舍不得放手;有时候，明知道纠缠于往事旧人只会徒增伤悲，却仍然执着的去回忆，去留恋。','file/newsPicture3.jpg','人生短短几十年，为什么要蹉跎浪费在无可挽回的失去上，为什么不酒脱一点，看开一点，活得轻松快乐一点。\n这世间，没有谁的人生是十全十美的，总要面对一些离别，总要经历一些失去，如果总对身边的一切执念太深，只会越活越累。\n时间不停向前，人也不可避免的要向前看。面对一些不如意、不顺心的事，该放的就放，该忘的就忘，别总把自己困在失败的悲伤中。\n生而为人，放不是无能，而是一种洒脱，忘更不是懦弱，而是一种智慧。\n在来去匆匆，聚散不定的现实里，放下不属于自己的感情，才能有新的开始，忘记心中的烦恼，才能收获愉快的心情。\n所以，有些离开的人，该放就放下吧，一直念念不忘，伤害的是自己，有些烦心事，该忘就忘了吧一直耿耿于怀，痛苦的是自己。\n-辈子本就不长，何必让自己活得那么累，过去的情就让它过去，别再留恋，想不通的事就算了，别再纠结。\n人生的旅途，总有些事让人烦，总有些情让人伤。只有学会忘记过往的不如意，忘记一些不必要的烦恼，以轻盈的身心重新出发，才不会被旧人旧事所累。\n记得，每个人心灵的空间都是有限的，当装多了纠结与伤感，就装不下自在与欢快了。要想日子过得简单轻松一点，就要懂得放下执念，忘掉痛苦，清除伤。'),(4,'2025-04-27 08:09:22','理想很丰满，现实很骨感','游戏里的你帅气无比，乘风御剑，通关杀敌无所不能，你满足于那其中的成就感，你满足于通关的畅快淋漓。','file/newsPicture4.jpg','年轻人，可那毕竟不是现实，理想很丰满，现实很骨感这不是玩笑，你不走出来，怎么会知\n你真的想等到某天喜欢上一个姑娘时，才去纠结咖啡钱电影钱你要如何与爸妈张口，才去苦恼为她买礼物你要怎样省吃俭用节衣缩食?\n你没有挥金如土的.魄力，没有殷实的家境，没有既定的光芒锦绣的前程，二十出头的年纪，你不努力，你想拿什么报答那个在你身边用最好的青春陪伴你的姑娘?你又拿什么报答含辛茹苦养育你这么多年的父母?\n生活不是游戏，不会给你那么多反复再来的机会，青春年少风华正茂，年轻人，你不努力，你想指望什么?\n年轻人，走出来奋斗吧!累也好苦也罢。如果你现在对自己各种放纵，你指望以后你用什么条件来放松?\n年轻人，你要努力赚钱，为了自己，也为了你爸妈。为了他们在以后逛商场的时候，可以给自己买东西像给你买东西一样毫不犹豫。为了他们可以在同老友谈起你时可以一脸安详，而不是想着，这个月，儿子交了房租还有钱吃饭么。我们这个年龄的人，已经像吸血鬼一样巴着父母活了二十多年了，还真的要继续吸着他们的血活下去么?\n年轻人，停止期望凡事简单容易。如果总是挑简单的事情做，那你永远成不了大器，生活总会在始料不及时考验你，所以你必须挑战困难，保持坚强，世上任何值得拥有的东西都需要付诸努力，勤奋与自律，倘若自甘平庸，那你就会变得庸碌无为。\n年轻人，与我们一起，挑战一下自己，拥抱一下梦想。你想要的生活，跳起来，一定够得到!'),(5,'2025-04-27 08:09:22','理想是一种精神上的追求','如果前方是一片黑暗，理想是否会黯淡?黑暗终究不能限制理想的步伐，只是需要时间。','file/newsPicture5.jpg','是否会撕裂黑暗的结界?给理想一点时间，是否会完成理想的目标?太多时候，黑给黑暗一缕曙光，暗限制了理想的脚步，时间成了撕裂黑暗的曙光。社会的压抑，未知的迷茫，甚至是事实的打击，都成了所谓的黑暗。\n理想应该是一种精神上的追求，一种我们内心深处的渴望。也许理想的种类太多，不一样的人也有不一样的理想。但唯一的共同点就是我们在追求，追求自己精神上亦或是心中的目标。但总是不尽人意，一来存在太多不确定因素，二来时间还不够。理想并不是一而就的空话。\n想过放弃，因为理想与现实的差距。但又不想放弃，因为理想是精神上的追求心中的渴望。纠结了太多，却是否想过在纠结的时候，已经选择了错过。被刻意选择的错过是什么?是路过。我们在不经意间路过了多少理想，只是因为纠结。如果坚定自己的理想，用时间去行动，是否会少几次刻意的错过:-次，与一位朋友谈到如何乐观，然后追求理想。朋友想了一会儿，给我的回答是正能量与时间。他说，想要乐观就要不断给自己正能量。事物有阴阳两面，如果阳代表乐观，那在我们看待一件事时要看阳面千万别看阴面。这样自己不会消极，某种程度上来说就是一种正能量。想要追求理想，务必要花费时间。正如没有风平浪静的大海，想要追求理想，要时间。给理想一点时间，让自己去追求，不顾切的追求。\n点点滴滴的小事构成了我们的生活，点点滴滴的努力给理想铺平了路。每一次小成功都为理想迈进了一步。每一次失败，都告诉我们一些教训，反方向来说为下一次成功提供了经验。不要觉得失败是可怕的，长远来看，正是失败才有了成功。\n时间在流逝。如果安于现状，就会乐不思。理想需要时间不代表我们可以挥霍，我们能做的是珍惜时间，去为理想拼搏。\n间接意义上讲，理想的时间是我们的努力。\n如果正在路上，一直任性向前走，忘记时间不回头。'),(6,'2025-04-27 08:09:22','人生如梦，梦想是帆','人生如梦，梦想是帆，每个人都有一个只属于自己的梦，但我们同属一个国家，所以每个人的梦又与国家的兴衰荣辱紧密相连。先哲顾炎武曾说:天下兴亡，匹夫有责。只有国家好，大家才能好。','file/newsPicture6.jpg','我依然清楚的记得:\n当甲午战争战败，日寇无礼踏破中国的门户;当八国联军侵入北京，无情掠夺中国的财产:当七七事变发生，中国的老人、妇孺被残忍杀害的时候，我在想那时中国的梦是怎样的!\n我虽不曾亲眼看到，但那却是铁一般的事实。因为从老人们那深邃的眼神中可以感到无尽的愤懑;从他们干瘪的脸颊可以看到深情的泪水，从他们嘹亮的军歌中可以想到那奋勇杀敌时的豪迈;从他们激昂话语中听到那誓要捍卫家园振兴中华的誓言。作为新一代青年的我们难道不应该树立远大的理想，付之以踏实的行动，去继承先辈们的使命。去实现中华民族的伟大崛起和复兴吗?\n有梦才能使中国繁荣!\n在改革开放以来中国取得了一系列的可以载入中国史册的成就。香港、澳门的回归，经济特区的建立，使中国成为发展国家中的经济大国，科技先进国和军事强国。当中国成功举办奥运的时候，当神九飞天的时候，当蛟龙入海的时候，当航母下水的时候，当莫言荣获诺贝尔文学奖的时候。我相信每个人都感觉到了无比的自豪。但是现在的中国与其他发达国家还有很大差距。作为新一代的我们，难道不应该志存高远吗?\n我想有的人会说，我们的力量是有限的。的确个人的力量很渺小，但是中国梦就是因一个个微不足道的个人的梦一直汇集、汇集，然后凝聚成的一个巨大的梦。冯至在《十四行诗》中写道，我们准备着，深深领受，那些意想不到的奇迹，在漫长的岁月里，忽然有彗星的出现，狂风乍起。\n梦想是美丽的，它是美的期望;梦想是阳光的，它使人由浮躁走向踏实;梦想是充满力量的，它可以激发人身体里无限的潜能。我们期盼的是国泰民安、经济发展、政治清明、文化繁荣、社会和谐、生态良\n好、公平正义。这才是中国人伟大的梦'),(7,'2025-04-27 08:09:22','若月亮没来-王宇宙Leto，乔浚丞','《若月亮没来(若是月亮还没来)》是王宇宙Leto，乔浚丞演唱的歌曲，于2024年1月22日上线发行。','file/newsPicture7.jpg','风吹过山 船靠了岸  风光呀 一点点看  我走向北 你去往南\n故事呀 一篇篇翻  好烦 又加班到很晚  你搭上空荡的 地铁已是末班\n好烦 很爱却要分开  恋爱谈不明白  好烦 接近理想好难 却又还很不甘\n如何拥抱平淡  如果 最难得到圆满  不如选择坦然 若是月亮还没来\n路灯也可照窗台  照着白色的山茶花微微开  若是晨风还没来\n晚风也可吹入怀  吹着那一地树影温柔摇摆  你总以为你不够好\n不够苗条和美貌  可是完美谁能达到  做你自己就很好\n烦恼烦恼拥有太少  没有房车没有钞票  可爱你的人永远会 \n把你当做心尖珍宝  我也懂大多数的时候  你只想逃离这世界\n我也懂太多的情绪在  一个人失眠的深夜 你可以是悲伤或者埋怨\n但请不要放弃明天  这一直灰暗的世界  我想看见你的笑脸\n若是月亮还没来  路灯也可照窗台  照着白色的山茶花微微开\n若是晨风还没来  晚风也可吹入怀  吹着那一地树影温柔摇摆\n若是月亮还没来  路灯也可照窗台  照着白色的山茶花微微开\n若是晨风还没来  晚风也可吹入怀  吹着那一地树影温柔摇摆\n李哲今年1月份创作了《若月亮没来》这首歌。随着歌曲的热度不断上升，约他写歌的人越来越多，他的工作变得更加繁忙。\n近年来，李哲凭借对音乐的热爱和不懈的努力，创作了几百首音乐作品，其中不乏广为人知的佳作，例如王栎鑫的《一个人》、何赛飞与叶炫清在央视演唱的《木兰诗》等歌曲，都是由李哲作曲。\n如今，李哲的音乐才华和努力得到了业界的广泛认可，他的音乐作品多次登上各大音乐平台的热歌榜，成为备受瞩目的新生代音乐人。现在，走在街头、坐在车里，经常会听到自己的作品。看到自己的音乐作品受到如此广泛的喜爱和认可，我感到非常有成就感。李哲笑着说，他会努力创作更多优秀音乐作品，为家乡争光。'),(8,'2025-04-27 08:09:22','-米阳光传递一份温暖','黑暗中跌倒，坚强里苦笑。只是因为青春还在，所以梦想一直在路上。当年华未曾老去，青春没有散场，留给幽暗的岁月，还有几分值得珍藏?孤独无助时、伤心难过时总爱恣意挥霍愤怒。伤了、痛了原本以为就都结束了;可是心里还不甘愿放弃，就只为一个理由，有梦想的人永不孤单。','file/newsPicture8.jpg','放进去了的青春，走不出来的悲伤却总是给年少时的我们留下太多无法割舍的情怀。记录岁月的足迹，聆听时光的故事。然轻吟浅唱出，青春嘉年华。\n故事里总会有，那些太多感慨于时间的无情，太多对往事的追忆，太多的太多，而今刻在了心里也停泻在了流年里。一段无法抹去的回忆，也只不过是一场烟火燃放的瞬间，却也一辈子在脑海里兜兜转转。很是怀念那些相遇的日子，邂逅了幸福也留在了时间轨迹里。时而想起，那些曾肩并肩奋斗的日子，那些写满感动与快乐的岁月。\n如今，我们似乎渐行渐远，彼此奋斗着青春的轮回。渐渐的，我们都长大了，时间改变了我们时刻分享彼此快乐与不快乐的习惯，青春的渐逝，岁月的更迭让我们变得都不再联系，身边的朋友也越来越少;那些欢笑，那些幸福的流年也随着我们的陌生而变得更加奢侈。也许多年以后，我们都有了自己的朋友，有了自己关心的人。那时，我们再细数那些癫狂在你生命里一辈子的记忆故事，蓦然发现一切都停留在了回忆里。'),(9,'2025-04-27 08:09:22','自己的路自己走，自己的心自己懂','岛上书店》中有句话:每个人的生命里，都有最艰难的那一年，将人生变得美好而辽阔。\n你有没有经历过那么一年，在走过的岁月中跋涉得异常艰难困苦，却仍无法灭前行的勇气。哪怕所有人都极力劝阻，也要不甘心地试一试;哪怕前方已没有道路，却还在坚定前行;哪怕再看不到任何希望，也要竭尽全力地为自己争取一个机会。','file/newsPicture9.jpg','你开始不动声色的扮演着一个大人，经历着生活日复一日的打。\n每天醒在天还没亮的五六点，挤过早高峰的地下铁，面对成山的工作，加班到深夜倒下就睡更成为了日常，还要应付各色的人际关系，逐渐开始接受努力也不一定有回报的道理。\n这段日子也许很长，但你没有放弃对生活的信心，始终相信人生总会变得一帆风顺，更坚信每件事的最后都会有一个好的结局，如果不是，说明还没到最后。\n于是你树立新的目标，让这一年的奔波更有方向。\n虽然永远无法预料明天是晴是雨，也无法预知你在乎的人是否还在身边，你一直以来的坚持究竟能换来什么。\n但你能决定的是，今天有没有备好雨伞，有没有好好爱人以及是否为自己追求的理想拼尽全力。\n永远不要只看见前方路途遥远而忘了从前的自己坚持了多久才走到了这里，\n今天拼尽全力虽然艰辛万分，在未来都将成为落在你身上的礼物。'),(10,'2025-04-27 08:09:22','愿你有明天可奔赴，有过往可回头','此去经年，用一张离家的车票，换一段有故事可说的人生。\n大概就是那时候怀揣着梦想，背上了行囊，一腔热血决定远行的你。独自拎着一只行李箱，背着双肩包在深夜抵达一个陌生的城市，站在人潮涌动的车站出口，望着宽敞公路上车水马龙的喧嚣，城市里亮如白昼的繁华。','file/newsPicture10.jpg','这世界上的人们都活的匆匆忙忙，每个人看起来都很焦虑，每个人都有自己的苦楚，却往往找不到人可以诉说。也许你的倾诉，对别人来说是一种打扰，而且别人没经历过你的经历，所以无法体会你的心情。我们总是在心情不好的时候拿着手机，翻翻通讯录，然后再默默放下手机，压住心中那股想要找人说说话的想法。\n等到低落的情绪慢慢有些好转，才开始明白，人这一生，无论是什么样的路，都是自己的选择，冲动也好，深思熟虑也罢，自己选的路，不管多难，都要自己走下去。心中的感受，不管是复杂还是简单，都只能自己来懂，别人帮不了你，也安慰不了你，顶多给你一些无济于事的劝告，最后还得靠自己想开。你选的幸福，你自己享受;你选的眼泪，你自己来流，生活就是如此，自己的路，自己走;自己的心，自己懂。');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='我的收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemintro`
--

DROP TABLE IF EXISTS `systemintro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemintro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `subtitle` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '副标题',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `picture1` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片1',
  `picture2` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片2',
  `picture3` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='网站介绍';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemintro`
--

LOCK TABLES `systemintro` WRITE;
/*!40000 ALTER TABLE `systemintro` DISABLE KEYS */;
INSERT INTO `systemintro` VALUES (1,'2025-04-27 08:09:22','网站介绍','WEBSITE INTRODUCTION','山川湖海，风雨雷电，花鸟虫鱼，这些都是大自然的奇妙造物，也是我们生命中最美好的遇见。在万籁俱寂的雪夜里，深邃>的星空映入眼帘，让我感受到生命的无限广阔与深沉；在烈日炎炎的夏日里，那炽热的阳光照射在身上，让我感受到生命的多彩与活力。','file/systemintroPicture1.jpg','file/systemintroPicture2.jpg','file/systemintroPicture3.jpg');
/*!40000 ALTER TABLE `systemintro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,71,'租客名1','zuke','租客','u2qvc6zep6pd2vlef3u3b6ehwx19uz3h','2025-04-27 08:30:13','2025-04-27 09:30:14');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '管理员' COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2025-04-27 08:09:22','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuyuekanfang`
--

DROP TABLE IF EXISTS `yuyuekanfang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuyuekanfang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '房屋图片',
  `fangwumianji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋面积/m3',
  `fangwudizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋地址',
  `zulinjiage` double NOT NULL COMMENT '租赁价格',
  `huxing` longtext COLLATE utf8mb4_unicode_ci COMMENT '户型',
  `fangdong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东',
  `fangdongxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东姓名',
  `zukeming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '租客名',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `yuyueshijian` datetime DEFAULT NULL COMMENT '预约时间',
  `zulinrenshu` int(11) DEFAULT NULL COMMENT '租赁人数',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`),
  KEY `zukeming` (`zukeming`,`xingming`),
  CONSTRAINT `yuyuekanfang_ibfk_1` FOREIGN KEY (`zukeming`, `xingming`) REFERENCES `zuke` (`zukeming`, `xingming`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预约看房';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuyuekanfang`
--

LOCK TABLES `yuyuekanfang` WRITE;
/*!40000 ALTER TABLE `yuyuekanfang` DISABLE KEYS */;
INSERT INTO `yuyuekanfang` VALUES (1,'2025-04-27 08:09:22','房屋名称1','file/yuyuekanfangFangwutupian1.jpg,file/yuyuekanfangFangwutupian2.jpg,file/yuyuekanfangFangwutupian3.jpg','房屋面积/m31','房屋地址1',1,'file/yuyuekanfangHuxing1.jpg,file/yuyuekanfangHuxing2.jpg,file/yuyuekanfangHuxing3.jpg','房东1','房东姓名1','租客名1','姓名1','2025-04-27 16:09:22',1,'是',''),(2,'2025-04-27 08:09:22','房屋名称2','file/yuyuekanfangFangwutupian2.jpg,file/yuyuekanfangFangwutupian3.jpg,file/yuyuekanfangFangwutupian4.jpg','房屋面积/m32','房屋地址2',2,'file/yuyuekanfangHuxing2.jpg,file/yuyuekanfangHuxing3.jpg,file/yuyuekanfangHuxing4.jpg','房东2','房东姓名2','租客名2','姓名2','2025-04-27 16:09:22',2,'是',''),(3,'2025-04-27 08:09:22','房屋名称3','file/yuyuekanfangFangwutupian3.jpg,file/yuyuekanfangFangwutupian4.jpg,file/yuyuekanfangFangwutupian5.jpg','房屋面积/m33','房屋地址3',3,'file/yuyuekanfangHuxing3.jpg,file/yuyuekanfangHuxing4.jpg,file/yuyuekanfangHuxing5.jpg','房东3','房东姓名3','租客名3','姓名3','2025-04-27 16:09:22',3,'是',''),(4,'2025-04-27 08:09:22','房屋名称4','file/yuyuekanfangFangwutupian4.jpg,file/yuyuekanfangFangwutupian5.jpg,file/yuyuekanfangFangwutupian6.jpg','房屋面积/m34','房屋地址4',4,'file/yuyuekanfangHuxing4.jpg,file/yuyuekanfangHuxing5.jpg,file/yuyuekanfangHuxing6.jpg','房东4','房东姓名4','租客名4','姓名4','2025-04-27 16:09:22',4,'是',''),(5,'2025-04-27 08:09:22','房屋名称5','file/yuyuekanfangFangwutupian5.jpg,file/yuyuekanfangFangwutupian6.jpg,file/yuyuekanfangFangwutupian7.jpg','房屋面积/m35','房屋地址5',5,'file/yuyuekanfangHuxing5.jpg,file/yuyuekanfangHuxing6.jpg,file/yuyuekanfangHuxing7.jpg','房东5','房东姓名5','租客名5','姓名5','2025-04-27 16:09:22',5,'是',''),(6,'2025-04-27 08:09:22','房屋名称6','file/yuyuekanfangFangwutupian6.jpg,file/yuyuekanfangFangwutupian7.jpg,file/yuyuekanfangFangwutupian8.jpg','房屋面积/m36','房屋地址6',6,'file/yuyuekanfangHuxing6.jpg,file/yuyuekanfangHuxing7.jpg,file/yuyuekanfangHuxing8.jpg','房东6','房东姓名6','租客名6','姓名6','2025-04-27 16:09:22',6,'是',''),(7,'2025-04-27 08:09:22','房屋名称7','file/yuyuekanfangFangwutupian7.jpg,file/yuyuekanfangFangwutupian8.jpg,file/yuyuekanfangFangwutupian9.jpg','房屋面积/m37','房屋地址7',7,'file/yuyuekanfangHuxing7.jpg,file/yuyuekanfangHuxing8.jpg,file/yuyuekanfangHuxing9.jpg','房东7','房东姓名7','租客名7','姓名7','2025-04-27 16:09:22',7,'是',''),(8,'2025-04-27 08:09:22','房屋名称8','file/yuyuekanfangFangwutupian8.jpg,file/yuyuekanfangFangwutupian9.jpg,file/yuyuekanfangFangwutupian10.jpg','房屋面积/m38','房屋地址8',8,'file/yuyuekanfangHuxing8.jpg,file/yuyuekanfangHuxing9.jpg,file/yuyuekanfangHuxing10.jpg','房东8','房东姓名8','租客名8','姓名8','2025-04-27 16:09:22',8,'是',''),(9,'2025-04-27 08:09:22','房屋名称9','file/yuyuekanfangFangwutupian9.jpg,file/yuyuekanfangFangwutupian10.jpg,file/yuyuekanfangFangwutupian11.jpg','房屋面积/m39','房屋地址9',9,'file/yuyuekanfangHuxing9.jpg,file/yuyuekanfangHuxing10.jpg,file/yuyuekanfangHuxing11.jpg','房东9','房东姓名9','租客名9','姓名9','2025-04-27 16:09:22',9,'是',''),(10,'2025-04-27 08:09:22','房屋名称10','file/yuyuekanfangFangwutupian10.jpg,file/yuyuekanfangFangwutupian11.jpg,file/yuyuekanfangFangwutupian12.jpg','房屋面积/m310','房屋地址10',10,'file/yuyuekanfangHuxing10.jpg,file/yuyuekanfangHuxing11.jpg,file/yuyuekanfangHuxing12.jpg','房东10','房东姓名10','租客名10','姓名10','2025-04-27 16:09:22',10,'是','');
/*!40000 ALTER TABLE `yuyuekanfang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zuke`
--

DROP TABLE IF EXISTS `zuke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zuke` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zukeming` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租客名',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shoujihao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `youxiang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zukeming` (`zukeming`),
  KEY `zuke_zukeming_xingming` (`zukeming`,`xingming`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='租客';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zuke`
--

LOCK TABLES `zuke` WRITE;
/*!40000 ALTER TABLE `zuke` DISABLE KEYS */;
INSERT INTO `zuke` VALUES (71,'2025-04-27 08:09:22','租客名1','123456','姓名1','男','file/zukeTouxiang1.jpg',1,'19819881111','102020001@qq.com'),(72,'2025-04-27 08:09:22','租客名2','123456','姓名2','男','file/zukeTouxiang2.jpg',2,'19819881112','102020002@qq.com'),(73,'2025-04-27 08:09:22','租客名3','123456','姓名3','男','file/zukeTouxiang3.jpg',3,'19819881113','102020003@qq.com'),(74,'2025-04-27 08:09:22','租客名4','123456','姓名4','男','file/zukeTouxiang4.jpg',4,'19819881114','102020004@qq.com'),(75,'2025-04-27 08:09:22','租客名5','123456','姓名5','男','file/zukeTouxiang5.jpg',5,'19819881115','102020005@qq.com'),(76,'2025-04-27 08:09:22','租客名6','123456','姓名6','男','file/zukeTouxiang6.jpg',6,'19819881116','102020006@qq.com'),(77,'2025-04-27 08:09:22','租客名7','123456','姓名7','男','file/zukeTouxiang7.jpg',7,'19819881117','102020007@qq.com'),(78,'2025-04-27 08:09:22','租客名8','123456','姓名8','男','file/zukeTouxiang8.jpg',8,'19819881118','102020008@qq.com'),(79,'2025-04-27 08:09:22','租客名9','123456','姓名9','男','file/zukeTouxiang9.jpg',9,'19819881119','102020009@qq.com'),(80,'2025-04-27 08:09:22','租客名10','123456','姓名10','男','file/zukeTouxiang10.jpg',10,'198198811110','1020200010@qq.com');
/*!40000 ALTER TABLE `zuke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zulinhetong`
--

DROP TABLE IF EXISTS `zulinhetong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zulinhetong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fangwumingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋名称',
  `fangwutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '房屋图片',
  `fangwumianji` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋面积/m3',
  `fangwudizhi` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋地址',
  `zulinjiage` double NOT NULL COMMENT '租赁价格',
  `huxing` longtext COLLATE utf8mb4_unicode_ci COMMENT '户型',
  `fangdong` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东',
  `fangdongxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房东姓名',
  `zukeming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '租客名',
  `xingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `zulinshijian` int(11) DEFAULT NULL COMMENT '租赁/月',
  `zulinrenshu` int(11) DEFAULT NULL COMMENT '租赁人数',
  `zulinjine` double DEFAULT NULL COMMENT '租赁金额',
  `hetongriqi` datetime DEFAULT NULL COMMENT '合同日期',
  `isUsed` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否使用',
  PRIMARY KEY (`id`),
  KEY `zukeming` (`zukeming`,`xingming`),
  CONSTRAINT `zulinhetong_ibfk_1` FOREIGN KEY (`zukeming`, `xingming`) REFERENCES `zuke` (`zukeming`, `xingming`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='租赁合同';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zulinhetong`
--

LOCK TABLES `zulinhetong` WRITE;
/*!40000 ALTER TABLE `zulinhetong` DISABLE KEYS */;
INSERT INTO `zulinhetong` VALUES (1,'2025-04-27 08:09:22','房屋名称1','file/zulinhetongFangwutupian1.jpg,file/zulinhetongFangwutupian2.jpg,file/zulinhetongFangwutupian3.jpg','房屋面积/m31','房屋地址1',1,'file/zulinhetongHuxing1.jpg,file/zulinhetongHuxing2.jpg,file/zulinhetongHuxing3.jpg','房东1','房东姓名1','租客名1','姓名1',1,1,1,'2025-04-27 16:09:22'),(2,'2025-04-27 08:09:22','房屋名称2','file/zulinhetongFangwutupian2.jpg,file/zulinhetongFangwutupian3.jpg,file/zulinhetongFangwutupian4.jpg','房屋面积/m32','房屋地址2',2,'file/zulinhetongHuxing2.jpg,file/zulinhetongHuxing3.jpg,file/zulinhetongHuxing4.jpg','房东2','房东姓名2','租客名2','姓名2',2,2,2,'2025-04-27 16:09:22'),(3,'2025-04-27 08:09:22','房屋名称3','file/zulinhetongFangwutupian3.jpg,file/zulinhetongFangwutupian4.jpg,file/zulinhetongFangwutupian5.jpg','房屋面积/m33','房屋地址3',3,'file/zulinhetongHuxing3.jpg,file/zulinhetongHuxing4.jpg,file/zulinhetongHuxing5.jpg','房东3','房东姓名3','租客名3','姓名3',3,3,3,'2025-04-27 16:09:22'),(4,'2025-04-27 08:09:22','房屋名称4','file/zulinhetongFangwutupian4.jpg,file/zulinhetongFangwutupian5.jpg,file/zulinhetongFangwutupian6.jpg','房屋面积/m34','房屋地址4',4,'file/zulinhetongHuxing4.jpg,file/zulinhetongHuxing5.jpg,file/zulinhetongHuxing6.jpg','房东4','房东姓名4','租客名4','姓名4',4,4,4,'2025-04-27 16:09:22'),(5,'2025-04-27 08:09:22','房屋名称5','file/zulinhetongFangwutupian5.jpg,file/zulinhetongFangwutupian6.jpg,file/zulinhetongFangwutupian7.jpg','房屋面积/m35','房屋地址5',5,'file/zulinhetongHuxing5.jpg,file/zulinhetongHuxing6.jpg,file/zulinhetongHuxing7.jpg','房东5','房东姓名5','租客名5','姓名5',5,5,5,'2025-04-27 16:09:22'),(6,'2025-04-27 08:09:22','房屋名称6','file/zulinhetongFangwutupian6.jpg,file/zulinhetongFangwutupian7.jpg,file/zulinhetongFangwutupian8.jpg','房屋面积/m36','房屋地址6',6,'file/zulinhetongHuxing6.jpg,file/zulinhetongHuxing7.jpg,file/zulinhetongHuxing8.jpg','房东6','房东姓名6','租客名6','姓名6',6,6,6,'2025-04-27 16:09:22'),(7,'2025-04-27 08:09:22','房屋名称7','file/zulinhetongFangwutupian7.jpg,file/zulinhetongFangwutupian8.jpg,file/zulinhetongFangwutupian9.jpg','房屋面积/m37','房屋地址7',7,'file/zulinhetongHuxing7.jpg,file/zulinhetongHuxing8.jpg,file/zulinhetongHuxing9.jpg','房东7','房东姓名7','租客名7','姓名7',7,7,7,'2025-04-27 16:09:22'),(8,'2025-04-27 08:09:22','房屋名称8','file/zulinhetongFangwutupian8.jpg,file/zulinhetongFangwutupian9.jpg,file/zulinhetongFangwutupian10.jpg','房屋面积/m38','房屋地址8',8,'file/zulinhetongHuxing8.jpg,file/zulinhetongHuxing9.jpg,file/zulinhetongHuxing10.jpg','房东8','房东姓名8','租客名8','姓名8',8,8,8,'2025-04-27 16:09:22'),(9,'2025-04-27 08:09:22','房屋名称9','file/zulinhetongFangwutupian9.jpg,file/zulinhetongFangwutupian10.jpg,file/zulinhetongFangwutupian11.jpg','房屋面积/m39','房屋地址9',9,'file/zulinhetongHuxing9.jpg,file/zulinhetongHuxing10.jpg,file/zulinhetongHuxing11.jpg','房东9','房东姓名9','租客名9','姓名9',9,9,9,'2025-04-27 16:09:22'),(10,'2025-04-27 08:09:22','房屋名称10','file/zulinhetongFangwutupian10.jpg,file/zulinhetongFangwutupian11.jpg,file/zulinhetongFangwutupian12.jpg','房屋面积/m310','房屋地址10',10,'file/zulinhetongHuxing10.jpg,file/zulinhetongHuxing11.jpg,file/zulinhetongHuxing12.jpg','房东10','房东姓名10','租客名10','姓名10',10,10,10,'2025-04-27 16:09:22');
/*!40000 ALTER TABLE `zulinhetong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-24 16:03:14
