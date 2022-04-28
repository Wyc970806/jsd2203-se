package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 通过提高每次读写的数据量减少实际读写的次数可以提高读写效率
 * 一组字节一组字节的读写数据称为块读写
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("setup.exe");
        FileOutputStream fos = new FileOutputStream("setup_cp.exe");

        /*
            java.io.InputStream上定义了块读字节数据的方法
            int read(byte[] data)
            一次性读取给定字节数组总长度的字节量并从字节数组第一个位置开始将读取到的
            数据全部存入数组，返回值为实际读取到的字节数。如果返回值为-1则表示读取
            到了流的末尾。

            setup.exe文件内容
            00110011 11001100 10101010 01010101 11110000 00001111

            byte[] data = new byte[4];//创建一个4字节长度的数组
            data:{00000000,00000000,00000000,00000000}
            int len;//用来表示每次实际读取到的字节数


            setup.exe文件内容
            00110011 11001100 10101010 01010101 11110000 00001111
            ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
            //第一次调用
            len = fis.read(data);//因为数组长度是4，所以可以一次性读4个字节
            data:{00110011,11001100,10101010,01010101}//将读取的4字节存入数组
            len:4   4表示实际读取到了4个字节


            setup.exe文件内容
            00110011 11001100 10101010 01010101 11110000 00001111 文件末尾
                                                ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                                实际只能读取到2字节
            //第二次调用
            len = fis.read(data);//因为数组长度是4，所以可以一次性读4个字节，但实际仅读取到了2个字节
            data:{11110000,00001111,10101010,01010101}
                 | 本地读取到的2字节 | |  上次的旧数据   |
            len:2    本次实际读取到了2个字节，意味着data数组只有前2个字节有用

            setup.exe文件内容
            00110011 11001100 10101010 01010101 11110000 00001111 文件末尾
                                                                  ^^^^^^^
                                                                  没有数据了
            //第三次调用
            len = fis.read(data);//一个字节都没有读取到
            data:{11110000,00001111,10101010,01010101}
                 |              都是旧数据            |
            len:-1 已经是文件末尾了！



            java.io.OutputStream超类上提供了块写操作
            void write(byte[] data)
            将给定的字节数组中所有数据一次性写出

            void write(byte[] data,int off,int len)
            一次性将给定的字节数组从下标off处开始的连续len个字节一次性写出
         */

        byte[] data = new byte[1024*10];//10kb
        int len;//记录每次实际读取到的字节数
        //16:45回来
        long start = System.currentTimeMillis();
        while( (len = fis.read(data)) != -1 ){
            fos.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕，耗时:"+(end-start)+"ms");

        fis.close();
        fos.close();
    }
}
