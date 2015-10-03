# sparknotes
Note anything during writing spark or scala python php golang gopher bigdata hadoop review 大数据 面试 面试题 大数据面试题 作者在Github的博客列表
- [Spark 笔记](http://devuser.github.io/spark-notes)
- [Docker 笔记](http://devuser.github.io/docker-notes)
- [Golang 笔记](http://devuser.github.io/golang-notes)

[从源代码开始](stepbystepfromsrc.md)

[PowerDesigner](powerdesigner.md)

[SPARK解决BAT问题](spark-bat.md)

[编写第一个Spark程序](case1_wordcount.md)

[机器学习](MLlib.md)

[推荐在豆瓣](recommenddation_in_douban.md)

[大数据面试题](bigdatareview.md)

本系列文档基于`Spark 1.5-Hadoop 2.6`撰写。

如果没有特殊声明，文档中案例在`Cent OS 6.X`系列下为准， 其他操作系统请参考。

## 幸福生活从Docker开始
在DockerHub搜索Spark `docker search -s 2 spark`

存在若干个Spark镜像，推荐选择 _ sequenceiq/spark _ 执行如下命令拉取 ｀docker pull sequenceiq/spark`

有强迫症的同学建议执行如下命令拉取该镜像的所有版本

`docker pull -a sequenceiq/spark`

拉取所有的版本是有意义的，因为Spark处在快速成长期，年初到现在从_ 1.2 _ 版本迭代到_ 1.5 _

目前市面上流行的印刷品的书，多数还是基于_ 1.2 _ 版本。 作为初学者来说，遇到版本差异，会非常痛苦。

所以我建议，使用与您印刷品的书一致的Spark版本。

# **机器学习框架（Spark MLlib)**
目前支持4种常见的机器学习问题：二元分类、回归、聚类以及协同过滤 - 依赖 （将会调用jblas线性代数库，这个库本身依赖于原生的Fortran程序 如果想用Python调用MLlib，需要安装NumPy 1.7或更新的版本 - 二元分类

```
是个监督学习问题。 目前支持两个适用于二元分类的标准模型家族：线性支持向量机（SVMs）和逻辑回归， 同时也分别适用于这两个模型家族的L1和L2正则化变体。

这些训练算法都利用了一个底层的梯度下降基础算法。 二元分类算法的输入值是一个正则项参数（regParam）和多个与梯度下降相关的参数（stepSize，numIterations，miniBatchFraction）

目前可用的二元分类算法：
- **SVMWithSGD**
- **LogisticRegressWithSGD**
```

- 线性回归
- 聚类
- 协同过滤 隐性反馈与协同反馈
- 梯度下降基础算法
- 二元分类
- 线性回归
- 聚类
- 协同过滤

# 搭建Hadoop单机版本和伪分布式开发环境
`sudo -s`进入**root**用户权限模式

`apt-get install vim`

Hadoop是采用SSH进行通讯的，此时要设置密码为空， 即不需要密码登录，这样免去每次通讯时都输入密码。

`apt-get install ssh`

安装完毕后启动SSH服务

`/etc/init.d/ssh start`

以下命令验证服务是否正常启动

`ps -e|grep ssh`

如下命令产生私钥和公钥

`ssh-keygen -t rsa -P ""`

使用Java自带的jps命令查询出所有的守护进程:

** @todo插入图片** - 创建HDFS的文件夹_/input_ `bin/hadoop dfs -mkdir /input` - 复制本地的配置文件到HDFS文件夹_/input* `bin/hadoop dfs -copyFromLocal etc/hadoop/_.xml /input`- 在刚刚构建的伪分布式模式下运行自带的_wordcount_程序`bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.0.jar wordcount /input /output`

# 开始第一个测试案例
- 启动Spark集群的Mater `$SPARK_HOME/sbin/start-master.sh`
- 启动Spark集群的Slaves `$SPARK_HOME/sbin/start-slaves.sh`
- 启动Hadoop集群`/data/hadoop/sbin/start-all.sh`

`hadoop dfs -copyFromLocal ./README.md /`

`val file = sc.textFile("hdfs://inside-bigdata04:9000/README.md")`

`file.filter(line => line.contains("Spark"))`

## 查看HDFS的文件或文件夹
- `hadoop dfs -get  hdfs://10.104.19.122:9000/foo.md`
- 查看文件末尾的若干行 `hadoop dfs -tail -f hdfs://10.104.19.122:9000/README.md`
- 列举HDFS的文件或文件夹 `hadoop dfs -ls  hdfs://10.104.19.122:9000/`

目前推荐如下命令

`hdfs dfs -ls /`

`hdfs dfs -ls  hdfs://$HADOOP_MASTER_ID:9000/`
