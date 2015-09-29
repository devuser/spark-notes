sbt 编译spark 的wordcount 程序
==============================

直接执行 sbt 会在当前目录下面创建 target 目录

sbt 的目录格局一般为 lib/ (该目录下存储与编译相关的 jar 文件) project/ src/main/scala/ src/main/test/scala

复制 jar 文件 spark-assembly *hadoop2.5.1.jar 到 lib 目录下\`[root@localhost word]# find ../spark -name “spark*jar” |grep assem ../spark/assembly/target/scala-2.10/spark-assembly-1.1.2-SNAPSHOT-hadoop2.5.1.jar ../spark/dist/lib/spark-assembly-1.1.2-SNAPSHOT-hadoop2.5.1.jar[root@localhost word]# cp ../spark/dist/lib/spark-assembly-1.1.2-SNAPSHOT-hadoop2.5.1.jar lib/[root@localhost word]# ls lib spark-assembly-1.1.2-SNAPSHOT-hadoop2.5.1.jar

编辑 wordcount.scala

import org.apache.spark.{SparkContext, SparkConf} import org.apache.spark.SparkContext._ object wordCount{

def main(args: Array[String]){ if (args.length == 0) { System.err.println("Usage bin/spark-submit [options] --class wordCount wordCount.jar file1:URI") System.err.println("Usage bin/spark-submit [options] --class wordCount wordCount.jar hdfs://172.16.1.141:9000/test.txt") System.exit(1); } val conf = new SparkConf().setAppName("WordCount") val sc = new SparkContext(conf) val doc = sc.textFile(args(0)) doc.cache() val words = doc.flatMap(*.split("")) val pairs = words.map( x=> (x,1)) val res = pairs.reduceByKey(*\+_) res.collect().foreach(println) sc.stop() } }

编辑 build.sbt

[root@localhost word]# cat build.sbt name := “wordCount”[blank line] version := “1.0”[blank line] scalaVersion := “2.11.4” 6 . 编译打包 成 jar 文件

[root@localhost word]# sbt package -Dsbt.ivy.home=/root/.ivy2[info] Set current project to wordCount (in build file:/opt/htt/temp_20140611/java/word/)[info] Updating {file:/opt/htt/temp_20140611/java/word/}word…[info] Resolving jline#jline;2.12 …[info] Done updating.[info] Compiling 2 Scala sources to /opt/htt/temp_20140611/java/word/target/scala-2.11/classes…[warn] Multiple main classes detected. Run 'show discoveredMainClasses' to see the list[info] Packaging /opt/htt/temp_20140611/java/word/target/scala-2.11/wordcount_2.11-1.0.jar …[info] Done packaging.[success] Total time: 11 s, completed Jan 5, 2015 8:37:38 AM[root@localhost word]#\`

编译 class 文件到当前目录`
scalac src/main/scala/wordCount.scala -cp lib/spark-assembly-1.1.2-SNAPSHOT-hadoop2.5.1.jar
` 调用spark 执行`
../spark/bin/spark-submit –class wordCount target/scala-2.11/wordcount_2.11-1.0.jar hdfs://172.16.1.141:9000/opt/old/htt/test/test.txt
` 参考文章： http://www.aboutyun.com/thread-8587-1-1.html
