第一课 HelloWorld
=================

在成功安装JDK后，配置如下几个环境变量

1.	$JAVA_HOME
2.	$PATH
3.	$CLASSPATH

打开 `Shell` 窗口，输入`java -version`查看安装的Java版本号。

```
java version "1.8.0_91" Java(TM) SE Runtime Environment (build 1.8.0_91-b14) Java HotSpot(TM) 64-Bit Server VM (build 25.91-b14, mixed mode)
```

在 `Shell` 窗口中输入 `echo $CLASSPATH`查看设置的类路径。

在后续命令行执行 `javac` 或 `java` 命令时，如果没有特殊声明将默认可以引用 `$CLASSPATH` 定义的路径下的包。

在Shell窗口中，切换到您常用的工作文件夹，当然您可以顺序执行如下三条命令，创建第一个 `Java` 文件。

```
mkdir -p $HOME/working/javastepbystep
cd $HOME/working/javastepbystep
touch HelloWorld.java
```

使用您常用的编辑器，比如 `Vim` 或 `Atom` 编辑 `HelloWorld.java`

```
import java.math.BigDecimal;


public class HelloWorld{
  public static void main(String args[]){
    double dblX;
    dblX = 3 + .2;
    System.out.println(dblX);
    System.out.printf("Sum of 3 and .2 as %f\n", dblX);

    BigDecimal x = new BigDecimal(3);
    BigDecimal y = new BigDecimal(.2);
    System.out.printf("Sum of BigDecimal 3 and .2 %f\n", x.add(y));
    System.out.printf("Sum of BigDecimal 3 and .2 toString %s\n", x.add(y).toString());
  }
}
```

回到 Shell 窗口，切换到您的工作文件夹，顺序输入如下命令编译上述文件。 编译后没有任何输出。

```
cd $HOME/working/javastepbystep
javac HelloWorld.java
```

现在我们开始运行成功编译的 `.class` 文件。

```
java -classpath . HelloWorld
```

输出结果

```
3.2
Sum of 3 and .2 as 3.200000
Sum of BigDecimal 3 and .2 3.200000
Sum of BigDecimal 3 and .2 toString 3.200000000000000011102230246251565404236316680908203125
```
