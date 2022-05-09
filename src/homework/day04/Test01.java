package homework.day04;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 改正下面程序的错误
 * 
 * 向文件testpw.txt中以UTF-8编码写入一行字符串：
 * 你好!我喜欢java!
 * 
 * 单词记一记:
 * print 打印
 * 
 * @author Xiloer
 *
 */
public class Test01 {
    //缺少main方法
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("testpw.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
//            OutputStreamWriter osw = new OutputStreamWriter(fos,"UFT-8");
                BufferedWriter bw = new BufferedWriter(osw);
                PrintWriter pw = new PrintWriter(bw);
        ){
            pw.println("你好!我喜欢java!");
//            system.out.println("写出完毕!");
            System.out.println("写出完毕!");
            /*
                 java.io.UnsupportedEncodingException: UFT-8
                         不支持      字符集   异常
             */
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("出错了!");
        }
    }

}
