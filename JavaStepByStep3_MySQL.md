第二课 MySQL
============

数据库链接
----------

-	驱动
-	链接字符串
-	端口
-	数据库实例

数值字段类型
------------

字符串字段类型
--------------

日期字段类型
------------

索引类型
--------

常用函数
--------

视图

存储过程

触发器

生成器

表空间

权限设置

```
CREATE DATABASE IF NOT EXISTS foo_db
    default charset utf8 COLLATE utf8_general_ci;
use foo_db;
```

```
drop table if exists users ;

create table if not exists users(
  id text,
  name text
  );

drop table if exists favorites;

 create table if not exists favorites(
 id text,
 userid integer,
 flag integer
 );

insert into users(id, name)
values('21341231231', 'Bob');


insert into users(id, name)
values('31231242322', 'Samantha');

select * from users;

select * from users where id = '21341231231';

```

导出数据库
----------

知识点

1.	`--extended-insert`
2.	`--default-character-set`
3.	`--no-data`
4.	`>`和`>>` 管道符号

```
mysqldump --no-data -u root --password=root -d \
  --default-character-set=utf8  \
  --extended-insert=False foo_db > foo_db.sql
```

查阅 `foo_db.sql` 的文件内容

```
-- MySQL dump 10.13  Distrib 5.5.50, for osx10.8 (i386)
--
-- Host: localhost    Database: foo_db
-- ------------------------------------------------------
-- Server version	5.5.50

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-06 17:42:35

```
