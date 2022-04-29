package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流是一对高级流，且是一对字符流。
 * 功能:块写文本数据加速
 *
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流
 *
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //向文件pw.txt中写入文本数据
        PrintWriter pw = new PrintWriter("pw.txt");
        pw.println("super idol的笑容都没你的甜。");
        pw.println("八月正午的阳光都没你耀眼。");
        System.out.println("写出完毕!");
        pw.close();

    }
}
