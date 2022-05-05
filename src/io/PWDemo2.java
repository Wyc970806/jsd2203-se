package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 在流连接中使用PrintWriter
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //如果希望有追加模式，则需要自行创建文件输出流并指定
        FileOutputStream fos = new FileOutputStream("pw.txt",true);
        //在转换流上加上字符集，可以按照指定字符集写出。
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        /*
            当PrintWriter第一个参数为流时，我们就支持再传入一个boolean值参数，如果该值为true则
            打开了自动行刷新功能。每当我们调用println方法后就会自动flush一次
            注意:调用print方法并不会自动flush！！！！！！！
         */
        PrintWriter pw = new PrintWriter(bw,true);

//        FileOutputStream fos = new FileOutputStream("pw.txt",true);
//        BufferedOutputStream bw = new BufferedOutputStream(osw);
        /*
            不要将PW直接链接在缓冲字节输出流上，因为PW内部总是链接这BW这个缓冲字符输出流了。
            不需要在缓冲字节流上再缓冲了，会降低效率
         */
//        PrintWriter pw = new PrintWriter(bw);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            pw.println(line);
        }
        System.out.println("写出完毕!");

        pw.close();

    }
}







