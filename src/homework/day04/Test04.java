package homework.day04;

import java.io.*;
import java.util.Scanner;

/**
 * 改错
 * 
 * 程序实现的是简易记事本工具。程序启动后向pw.txt文件写内容
 * 用户输入的每一行字符串都写入到文件中，单独输入exit时
 * 程序退出。
 * 
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		try(
				//低级流方向错误
//			FileInputStream fos = new FileInputStream("pw.txt");
			FileOutputStream fos = new FileOutputStream("pw.txt");
			//字符集名字拼写错误
//			OutputStreamWriter osw = new OutputStreamWriter(fos,"UFT-8");

			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw,true);

//			PrintWriter pw = new PrintWriter("pw.txt","UTF-8");
		) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请开始输入内容");
			while (true) {
				String str = scanner.nextLine();
				if ("exit".equals(str)) {
					break;
				}
//				pw.println(srt);
				pw.println(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
