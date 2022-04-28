package io;

import java.io.*;

/**
 * 读写int值
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        //向文件中保存一个int值
        FileOutputStream fos = new FileOutputStream("int.dat");

        int max = Integer.MAX_VALUE;
        /*
            int最大值的2进制:
            01111111 11111111 11111111 11111111

            希望保存到文件中时:
            01111111

                                       vvvvvvvv
            00000000 00000000 00000000 01111111
            fos.write(max>>>24)
         */
        fos.write(max>>>24);//向文件中写入第一个字节，是max的2进制的最高8位
        /*
                     希望写出
                     VVVVVVVV
            01111111 11111111 11111111 11111111

            max>>>16
            00000000 00000000 01111111 11111111
                                       ^^^^^^^^
                                       实际写出
         */
        fos.write(max>>>16);
        fos.write(max>>>8);
        fos.write(max);
        /*
            写出后文件内容
            01111111 11111111 11111111 11111111
         */
        System.out.println("写出完毕");
        fos.close();


        /*
            文件内容
            01111111 11111111 11111111 11111111
         */
        FileInputStream fis = new FileInputStream("int.dat");
        /*
            文件内容
            01111111 11111111 11111111 11111111
            ^^^^^^^^

            int d1 = fis.read();
            d二进制:00000000 00000000 00000000 01111111
         */
        int d1 = fis.read();
        System.out.println(d1);//127
        /*
            文件内容
            01111111 11111111 11111111 11111111
                     ^^^^^^^^

            int d2 = fis.read();
            d2二进制:00000000 00000000 00000000 11111111
         */
        int d2 = fis.read();
        System.out.println(d2);//255

        int d3 = fis.read();//255
        int d4 = fis.read();//255
        /*
            d1:00000000 00000000 00000000 01111111
            d2:00000000 00000000 00000000 11111111
            d3:00000000 00000000 00000000 11111111
            d4:00000000 00000000 00000000 11111111

            d1<<24:01111111 00000000 00000000 00000000
            d2<<16:00000000 11111111 00000000 00000000
            d3<<8:00000000 00000000 11111111 00000000
            d4<<0:00000000 00000000 00000000 11111111
         */
        System.out.println(Integer.toBinaryString(d1<<24));
        System.out.println(Integer.toBinaryString(d2<<16));
        System.out.println(Integer.toBinaryString(d3<<8));
        System.out.println(Integer.toBinaryString(d4<<0));

        int d = d1<<24 | d2<<16 | d3<<8 | d4<<0;
        System.out.println(d);

    }
}
