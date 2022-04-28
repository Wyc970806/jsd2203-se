package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("demo.txt");
        /*
            UTF-8
            英文占1字节，中文占3字节
         */
        String line = "一给窝里giao~~";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        line = "我太难了~~~";
        data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        System.out.println("写出完毕!");
        fos.close();

    }
}



