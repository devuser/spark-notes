第四课 MySQL
============

术语表
------

-	`dp` 示例用的数据库名称
-	`root` 缺省用户名和密码

前置条件
--------

1.	Docker环境
2.	docker pull mysql:5.6

在Docker中启动 `some-mysql` 进入 `some-mysql`

```
  docker start some-mysql
  docker exec -it some-mysql bash
```

进入上述命令启动的 `Shell` 窗口输入如下命令进入 `MySQL` 的控制台， 特别注意其中的设定字符集为 `utf8`

```
cd /data/boyosoft/sql
mysql -u root --password=root --default-character-set=utf8 dp
```

卸载已经创建的数据库，重新创建

```
drop database if exists dp;

CREATE DATABASE IF NOT EXISTS dp
    default charset utf8 COLLATE utf8_general_ci;

use dp;
```

准备sql文件

1.	复制 `resources/sql/dp_init.sql`到您创建容器 `some-mysql`时绑定的`/data/boyosoft/sql`文件夹
2.	复制 `resources/sql/dp_raw.sql`到您创建容器 `some-mysql`时绑定的`/data/boyosoft/sql`文件夹。

执行如下命令导入数据库

```
\. dp_init.sql
\. dp_raw.sql
```
