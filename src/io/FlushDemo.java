package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲输出流写出数据的缓冲区问题
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "该配合你演出的我演视而不见。";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);
        System.out.println("写出完毕");
        /*
            java.io.Flushable接口,里面定义了抽象方法flush(),作用是将缓冲流的
            缓冲区中已经缓存的数据一次性写出
            java.io.OutputStream实现了该接口，这意味着所有的字节输出流都有这个
            方法，但是只有缓冲输出流真正实现了该方法的功能，其它的高级输出流flush
            方法的作用仅仅是调用其连接的流的flush方法将该动作传递下去，直到传递给
            缓冲流的flush做实际操作。
         */
//        bos.flush();//冲

        bos.close();

    }
}
