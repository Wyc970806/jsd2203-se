package io;

import java.io.*;

/**
 * 使用缓冲字符输入流java.io.BufferedReader读取文本数据
 * 缓冲字符输入流是一个高级流，有两个主要功能:
 * 1:块读文本数据加速
 * 2:可以按行读取字符串
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码输出到控制台上
        FileInputStream fis = new FileInputStream("./src/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br  = new BufferedReader(isr);
        String line;
        /*
            BufferedReader的readLine方法是它的独有方法，作用是读取一行字符串
            该方法返回的字符串不包含最后的换行符。如果读取了一个空行(这一行只有换行符)，那么
            返回值为空字符串，即:""。如果返回值为null则表示流读取到了末尾。
         */
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
