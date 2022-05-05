package io;

import java.io.*;

/**
 * 在流连接中使用PrintWriter
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //如果希望有追加模式，则需要自行创建文件输出流并指定
        FileOutputStream fos = new FileOutputStream("pw.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("让我掉下眼泪的，不止昨夜的酒。");
        pw.println("让我依依不舍的，不止你的温柔。");

        System.out.println("写出完毕!");

        pw.close();

    }
}







