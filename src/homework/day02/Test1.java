package homework.day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 实现一个记事本工具
 * 程序启动后要求将用户在控制台上输入的每一行字符串都写入到文件note.txt中
 * 如果用户在控制台单独输入了"exit"时，程序退出
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("note.txt");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String line = scanner.nextLine();//获取用户输入的一行字符串
            /*
                当我们使用字符串的字面量与一个字符串变量进行equals判断时，应当
                写为字面量equals变量，避免空指针异常的发生。
             */
            if("exit".equals(line)){
//            if(line.equals("exit")){
                break;
            }
            byte[] data = line.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
        }
        System.out.println("再见!");
        fos.close();

    }
}
