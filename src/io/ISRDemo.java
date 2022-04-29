package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 转换输入流测试字符流读取字符的操作
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        /*
            字符流的读取字符方法:
            int read()
            读取一个字符，返回值实际上是一个char.但是是以int型返回。意味着返回的int
            值低16位有效。如果返回值为int型-1表示末尾。

         */
//        int d = isr.read();

        int d;
        while((d = isr.read())!=-1) {
            System.out.print((char) d);
        }
        isr.close();

    }
}



