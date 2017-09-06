第十一课 Redis
==============

术语表
------

-	`:foo` 临时键值，仅用于开发或测试过程中观察使用
-	`JSON` 一种文件格式，比XML格式简单

前置条件
--------

1.	`Docker` 环境
2.	`docker pull redis:latest`

在 `Docker` 中启动 `some-redis` 进入 `some-redis`

```
docker start some-redis
```

启动 `Redis` 客户端，链接到刚才启动的服务器

```
  docker run -it --link some-redis:redis --rm redis redis-cli -h redis -p 6379
```
