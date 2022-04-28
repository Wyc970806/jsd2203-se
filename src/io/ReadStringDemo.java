package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 读取文件中的文本数据
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("demo.txt");
        //将demo.txt文件中所有数据读取回来
        FileInputStream fis = new FileInputStream(file);
        long len = file.length();//获取文件的大小，单位字节
        byte[] data = new byte[(int)len];//常见与文件大小一致的字节数组
        fis.read(data);//块读，将文件所有字节读到data数组中
        /*
            Standard 标准
            Charsets 字符集
         */
        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);

        fis.close();

    }
}
