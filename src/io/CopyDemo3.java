package io;

import java.io.*;

/**
 * JAVA将流分为了两类:节点流与处理流
 * 节点流:又称为低级流，是实际链接程序与另一端的"管道"，负责实际读写数据的流。
 *       读写一定是建立在低级流的基础上进行的。
 * 处理流:又称为高级流，不能独立存在，必须链接在其它流上，目的是当数据流经当前
 *       流时对数据进行某种加工处理，简化我们相应的操作。
 * 实际开发中，我们总是会串联一组高级流到一个低级流上，以流水线式的加工处理完成
 * 读写的操作，这个过程也成为"流的链接"
 *
 * 缓冲流:
 * java.io.BufferedInputStream和BufferedOutputStream
 * 它们同样继承自InputStream和OutputStream
 *
 * 缓冲流的功能是提高读写效率。
 *
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("setup.exe");
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("setup_cp.exe");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int d = 0;
        long start = System.currentTimeMillis();
        while((d = bis.read()) != -1) {
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!耗时:"+(end-start)+"ms");

        bis.close();
        bos.close();
    }
}
