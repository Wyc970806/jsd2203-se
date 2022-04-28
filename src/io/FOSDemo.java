package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  JAVA IO
 *  IO指的是输入与输出，Input和Output
 *
 *  java将输入与输出比作流: 流可以理解为是顺着同一个方向移动的过程，即:流动的概念
 *  输入流:想象为是一个"管道"，链接着我们写的java程序与另一端的管道，而流动的方向
 *        是从另一端移动到我们的程序的过程,是一个获取的过程，操作为"读"
 *  输出流:方向从我们写的程序到另一端的方向，操作为:"写"
 *
 *  java为了规范流的行为，定义了两个超类:
 *  java.io.InputStream和java.io.OutputStream
 *  java.io.InputStream是所有字节输入流的超类(同时是抽象类)
 *      定义了几个常见的抽象方法:
 *      int read():读取一个字节
 *      int read(byte[] data):块读取操作
 *
 *  java.io.OutputStream是所有字节输出流的超类(同时是抽象类)
 *      void write(int d):写出一个字节
 *      void write(byte[] data):块写操作
 *      void write(byte[] data,int off,int len):块写部分数据。
 *
 *
 *  文件流:
 *  java.io.FileInputStream和FileOutputStream
 *  文件流继承自java.io.InputStream和OutputStream
 *  这对流是用来读写文件的流
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {

        /*
            常见构造器:
            FileOutputStream(String pathname)
            参数为写出的文件的路径

            FileOutputStream(File file)
            参数为写出的文件所对应的File实例

            创建文件输出流时，如果指定的文件不存在文件流会自动将该文件创建出来
            但是如果指定的文件所在的目录不存在时，实例化会抛出异常:
            java.io.FileNotFoundException
            即:文件没找到异常
         */
        //向当前目录下的fos.dat文件中写入数据
        /*
            相对路径中"./"可以忽略不写，默认就是从"./"开始的
            比如: "./fos.dat"等价与"fos.dat"
                 "./demo/fos.dat"等价于"demo/fos.dat"
         */
        FileOutputStream fos = new FileOutputStream("fos.dat");
//        File file = new File("fos.dat");
//        FileOutputStream fos = new FileOutputStream(file);
        /*
            字节输出流的超类OutputStream上定义了写出一个字节的基础操作
            void write(int d):写出一个字节

            因此文件流上就具有该方法，实现的目标就是将字节写入到文件中

            该方法要求传入一个int值，作用是将该int值对应的2进制的低八位
            写入到文件中。
                                       vvvvvvvv
            00000000 00000000 00000000 00000000
         */

        /*
            fos.write(1)

            int型整数1的2进制：
            00000000 00000000 00000000 00000001
                                       ^^^^^^^^
                                       写出的字节

           写出后，fos.dat文件中内容为:
           00000001

         */
        fos.write(-1);
        /*
            fos.write(2)

            int型整数2的2进制：
            00000000 00000000 00000000 00000010
                                       ^^^^^^^^
                                       写出的字节

           写出后，fos.dat文件中内容为:
           00000001 00000010
         */
        fos.write(2);

        System.out.println("写出完毕!");
        fos.close();

    }
}
