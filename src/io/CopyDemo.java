package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 * 思路:
 * 1:先创建一个文件输入流用于读取原文件
 * 2:再创建一个文件输出流用于将数据抄到复制的文件中
 * 3:顺序的从原文件中读取每一个字节并写入到复制的文件中
 *
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("image.jpg");
//        FileOutputStream fos = new FileOutputStream("image_cp.jpg");

        FileInputStream fis = new FileInputStream("setup.exe");
        FileOutputStream fos = new FileOutputStream("setup_cp.exe");

        /*
            例如:
            image.jpg文件内容
            01111001 11001100 00001111 11110000 10101010 01010101...
            ^^^^^^^^
            第一次调用:
            byte d = fis.read();
            d的2进制:00000000 00000000 00000000 01111001

            目标是将读取到的第一个字节写入到复制文件的第一个字节的位置上
            第一次调用
            fos.write(d);
            写的是d的2进制的低八位到文件image_cp.jpg中
            d的2进制:00000000 00000000 00000000 01111001
                                               ^^^^^^^^
                                               写出的字节
            image_cp.jpg文件内容:
            01111001
         */
        int d = 0;
        long start = System.currentTimeMillis();
        while((d = fis.read()) != -1) {
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!耗时:"+(end-start)+"ms");
        fis.close();
        fos.close();
    }
}
