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
        /*
            构造器:
            FileOutputStream(String pathname)
            FileOutputStream(File file)
            以上这两种方式创建的文件流为覆盖模式。
            覆盖模式指:文件流在创建时，如果指定的文件已经存在了则会将该文件内容全
            部清空。

         */
        FileOutputStream fos = new FileOutputStream("demo.txt");
        /*
            UTF-8
            英文占1字节，中文占3字节
         */
//        String line = "一给窝里giao~~";
//        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);

        String line1 = "我太难了~~~";
        byte[] data1 = line1.getBytes(StandardCharsets.UTF_8);
        fos.write(data1);

        String line2 = "嘿嘿嘿~";
        byte[] data2 = line2.getBytes(StandardCharsets.UTF_8);
        fos.write(data2);


        System.out.println("写出完毕!");
        fos.close();

    }
}



