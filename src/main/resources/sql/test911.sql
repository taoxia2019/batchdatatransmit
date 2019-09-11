/*
SQLyog Enterprise - MySQL GUI v6.14
MySQL - 5.5.62 : Database - appraisaltest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `appraisaltest`;

USE `appraisaltest`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `appraisalitem` */

DROP TABLE IF EXISTS `appraisalitem`;

CREATE TABLE `appraisalitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `beikaohedanwei` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  `biaozhun` varchar(255) DEFAULT NULL,
  `caozuofu` varchar(255) DEFAULT NULL,
  `danwei` varchar(255) DEFAULT NULL,
  `kaohedanwei` varchar(255) DEFAULT NULL,
  `kaohejieguo` double DEFAULT NULL,
  `kaohexiangmu` varchar(255) DEFAULT NULL,
  `kaohezhouqi` varchar(255) DEFAULT NULL,
  `mubiaozhi` double DEFAULT NULL,
  `shijishi` double DEFAULT NULL,
  `zhouqi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `appraisalitem` */

insert  into `appraisalitem`(`id`,`beikaohedanwei`,`beizhu`,`biaozhun`,`caozuofu`,`danwei`,`kaohedanwei`,`kaohejieguo`,`kaohexiangmu`,`kaohezhouqi`,`mubiaozhi`,`shijishi`,`zhouqi`) values (1,'铸轧分厂',NULL,'100','(shijizhi-mubiaozhi)*5.3','%','生产技术部',NULL,'生产计划完成率','8月',NULL,NULL,'月'),(2,'铸轧分厂',NULL,'204','(shijizhi-mubiaozhi)*13000','元/吨','财务管理部',NULL,'scr3000成本','8月',NULL,NULL,'季'),(3,'铸轧分厂',NULL,'91','(shijizhi-mubiaozhi)*500','%','生产技术部',NULL,'scra3000台效','8月',NULL,NULL,'月'),(4,'铸轧分厂',NULL,'90','(shijizhi-mubiaozhi)*500','%','生产技术部',NULL,'scra4500台效','8月',NULL,NULL,'月');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
