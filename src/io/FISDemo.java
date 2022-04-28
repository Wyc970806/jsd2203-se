package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件输入流读取文件数据
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./fos.dat");
        /*
            InputStream这个超类上定义了基础的读取字节的方法:
            int read()
            读取1个字节，将读取到的字节(8位2进制)放在返回的int值对应的2进制的
            最低8位上。如果返回的int值为整数-1则表示流读取到了末尾。

            文件流实现了该方法，作用是从文件中顺序的读取每一个字节。
         */
        /*
            fos.dat文件中的内容:
            00000001 00000010
            ^^^^^^^^

            int d = fis.read();//第一次调用相当于读取文件的第一个字节
            读取到的字节是:00000001

            而read方法返回的int值2进制的样子:
            00000000 00000000 00000000 00000001
            |-----前24位2进制全部补0---| |读取的字节|
         */
        int d = fis.read();//第一次调用相当于读取文件的第一个字节
        System.out.println(d);//1
        /*
            fos.dat文件中的内容:
            00000001 00000010
                     ^^^^^^^^

            d = fis.read();//第二次调用相当于读取文件的第二个字节
            读取到的字节是:00000010

            而read方法返回的int值2进制的样子:
            00000000 00000000 00000000 00000010
            |-----前24位2进制全部补0---| |读取的字节|
         */
        d = fis.read();//2
        System.out.println(d);
        /*
            fos.dat文件中的内容:
            00000001 00000010 文件末尾(没有第三个字节)
                              ^^^^^^^^

            d = fis.read();//第三次调用相当于读取文件的第三个字节
            读取到的字节是:没有读取到数据

            而read方法返回的int值2进制的样子:
            11111111 11111111 11111111 11111111
            -1则表示流读取到了末尾。
         */
        d = fis.read();
        System.out.println(d);

        fis.close();
    }
}
