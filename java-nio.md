Java NIO使用及原理分析 (一) 分类： JAVA语言 2011-07-17 15:41 16868人阅读 评论(3) 收藏 举报 javabufferimportexceptionstringclass 转载自：李会军•宁静致远 最近由于工作关系要做一些Java方面的开发，其中最重要的一块就是Java NIO（New I/O），尽管很早以前了解过一些，但并没有认真去看过它的实现原理，也没有机会在工作中使用，这次也好重新研究一下，顺便写点东西，就当是自己学习 Java NIO的笔记了。本文为NIO使用及原理分析的第一篇，将会介绍NIO中几个重要的概念。 在Java1.4之前的I/O系统中，提供的都是面向流的I/O系统，系统一次一个字节地处理数据，一个输入流产生一个字节的数据，一个输出流消费一个字节的数据，面向流的I/O速度非常慢，而在Java 1.4中推出了NIO，这是一个面向块的I/O系统，系统以块的方式处理处理，每一个操作在一步中产生或者消费一个数据库，按块处理要比按字节处理数据快的多。 在NIO中有几个核心对象需要掌握：缓冲区（Buffer）、通道（Channel）、选择器（Selector）。 缓冲区Buffer 缓冲区实际上是一个容器对象，更直接的说，其实就是一个数组，在NIO库中，所有数据都是用缓冲区处理的。在读取数据时，它是直接读到缓冲区中的； 在写入数据时，它也是写入到缓冲区中的；任何时候访问 NIO 中的数据，都是将它放到缓冲区中。而在面向流I/O系统中，所有数据都是直接写入或者直接将数据读取到Stream对象中。 在NIO中，所有的缓冲区类型都继承于抽象类Buffer，最常用的就是ByteBuffer，对于Java中的基本类型，基本都有一个具体Buffer类型与之相对应，它们之间的继承关系如下图所示：

下面是一个简单的使用IntBuffer的例子： [java] view plaincopyprint? import java.nio.IntBuffer;  

public class TestIntBuffer {<br>   public static void main(String[] args) {<br>       // 分配新的int缓冲区，参数为缓冲区容量<br>       // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。<br>       IntBuffer buffer = IntBuffer.allocate(8);  

```
   for (int i = 0; i < buffer.capacity(); ++i) {  
       int j = 2 * (i + 1);  
       // 将给定整数写入此缓冲区的当前位置，当前位置递增  
       buffer.put(j);  
   }  

   // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0  
   buffer.flip();  

   // 查看在当前位置和限制位置之间是否有元素  
   while (buffer.hasRemaining()) {  
       // 读取此缓冲区当前位置的整数，然后当前位置递增  
       int j = buffer.get();  
       System.out.print(j + "  ");  
   }
```

   }  

}<br>运行后可以看到：

在后面我们还会继续分析Buffer对象，以及它的几个重要的属性。 通道Channel 通道是一个对象，通过它可以读取和写入数据，当然了所有数据都通过Buffer对象来处理。我们永远不会将字节直接写入通道中，相反是将数据写入包含一个或者多个字节的缓冲区。同样不会直接从通道中读取字节，而是将数据从通道读入缓冲区，再从缓冲区获取这个字节。 在NIO中，提供了多种通道对象，而所有的通道对象都实现了Channel接口。它们之间的继承关系如下图所示：

使用NIO读取数据 在前面我们说过，任何时候读取数据，都不是直接从通道读取，而是从通道读取到缓冲区。所以使用NIO读取数据可以分为下面三个步骤：
1. 从FileInputStream获取Channel
2. 创建Buffer
3. 将数据从Channel读取到Buffer中
4. 下面是一个简单的使用NIO从文件中读取数据的例子：
5. [java] view plaincopyprint?
6. import java.io.*;  
7. import java.nio.*;  
8. import java.nio.channels.*;  

public class Program {<br>   static public void main( String args[] ) throws Exception {<br>       FileInputStream fin = new FileInputStream("c:\test.txt");  

```
   // 获取通道  
   FileChannel fc = fin.getChannel();  

   // 创建缓冲区  
   ByteBuffer buffer = ByteBuffer.allocate(1024);  

   // 读取数据到缓冲区  
   fc.read(buffer);  

   buffer.flip();  

   while (buffer.remaining()>0) {  
       byte b = buffer.get();  
       System.out.print(((char)b));  
   }  

   fin.close();
```

   }<br>}<br>使用NIO写入数据 使用NIO写入数据与读取数据的过程类似，同样数据不是直接写入通道，而是写入缓冲区，可以分为下面三个步骤：
1. 从FileInputStream获取Channel
2. 创建Buffer
3. 将数据从Channel写入到Buffer中
4. 下面是一个简单的使用NIO向文件中写入数据的例子：
5. [java] view plaincopyprint?
6. import java.io.*;  
7. import java.nio.*;  
8. import java.nio.channels.*;  

public class Program {<br>   static private final byte message[] = { 83, 111, 109, 101, 32,<br>       98, 121, 116, 101, 115, 46 };  

   static public void main( String args[] ) throws Exception {<br>       FileOutputStream fout = new FileOutputStream( "c:\test.txt" );  

```
   FileChannel fc = fout.getChannel();  

   ByteBuffer buffer = ByteBuffer.allocate( 1024 );  

   for (int i=0; i<message.length; ++i) {  
       buffer.put( message[i] );  
   }  

   buffer.flip();  

   fc.write( buffer );  

   fout.close();
```

   }<br>}<br>本文介绍了Java NIO中三个核心概念中的两个，并且看了两个简单的示例，分别是使用NIO进行数据的读取和写入，Java NIO中最重要的一块Nonblocking I/O将在第三篇中进行分析，下篇将会介绍Buffer内部实现。
