package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * JAVA将流按照读写单位划分为字节流与字符流
 * java.io.InputStream和OutputStream是所有字节输入流与输出流的超类
 *
 * java.io.Reader和Writer则是所有字符输入流与输出流的超类
 *
 * InputStream和OutputStream 与 Reader和Writer 是平级关系，相互不存在继承关系
 *
 * 字符流里也同样定义了对应的读取和写出方法，只是单位都以字符为最小单位读写。
 *
 *
 * 转换流
 * java.io.InputStreamReader和OutputStreamWriter
 * 它们是常用的字符流的一对实现类，同时它们也是一对高级流。
 * 它在流连接中的作用2个:
 * 1:衔接字节流与字符流
 * 2:将字节与字符进行转换方便读写。
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入字符串
        FileOutputStream fos = new FileOutputStream("osw.txt");
        /*
            转换流通常需要传入第二个参数用来明确字符集。这样通过当前流写出的字符
            都会按照该字符集转换为字节后写出

            16：45回来
         */
        OutputStreamWriter osw = new OutputStreamWriter(
                fos,StandardCharsets.UTF_8);

        //转换流会将写出的字符串转换为字节后再通过链接的文件流写入文件。
        osw.write("摩擦摩擦~在光滑的马路牙子上打出溜滑~");
        osw.write("我的滑板鞋~时尚时尚最时尚~");
        System.out.println("写出完毕!");
        osw.close();
    }
}
