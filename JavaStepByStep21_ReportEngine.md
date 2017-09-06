报表引擎
========

报表引擎生产环境下地址模版
--------------------------

```
http://127.0.0.1:28080/birt-viewer/preview?__report=wo%2Erptdesign&__format=html&xmlurl=http%3A%2F%2F172%2E17%2E0%2E4%3A8080%2Fgbocpts-0.1%2Fworkorder%2FxmlList%3Fworkordercodelist%3DW2016092100000001
```

参数清单
--------

1.	`__report` 注意双下划线前缀
2.	`__format` 注意双下划线前缀
3.	`xmlurl` XML数据源的地址

```
 http:/....../xxx?idlist=...

```

启动`Birt`容器

1.	创建本地文件夹，保存报表模版。 比如下面把报表模版保存在 `/Users/devuser/working/gbocptsdev/reports`
2.	启动时，将其映射到`/var/lib/tomcat7/webapps/birt/reports`
3.	使用58080端口映射到8080端口
4.	参数`-it`和`--rm`，请参考Docker官网

```
docker run -it --rm  --name birt \
  -v /Users/devuser/working/gbocptsdev/reports:/var/lib/tomcat7/webapps/birt/reports \
  -p 58080:8080 lavadiablo/docker-birt-host bash
```

1.	启动容器后，进入`Shell`窗口
2.	切换工作目录到`/var/lib/tomcat7/webapps/birt`
3.	执行命令`/usr/share/tomcat7/bin/catalina.sh run`启动 `Birt`
4.	打开浏览器访问如下网址

```
http://127.0.0.1:58080/birt
```

1.	点击 `View Example`查看自带的报表模版
2.	回到容器Shell窗口，输入 `Ctrl+C`停止Birt
3.	复制`/var/lib/tomcat7/webapps/birt/reports`下的模版文件到`/var/lib/tomcat7/webapps/birt`
4.	执行命令`/usr/share/tomcat7/bin/catalina.sh run`启动 `Birt`
5.	假定您刚刚复制的报表名称 `cpfctest` 在浏览器中输入如下地址
6.	在浏览器中查看您的报表`cpfctest`

```
http://127.0.0.1:58080/birt/frameset?__report=cpfctest.rptdesign
```
