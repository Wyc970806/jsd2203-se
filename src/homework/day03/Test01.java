package homework.day03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 改正下面程序的错误
 * 
 * 程序实现的功能需求:复制一个文件
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		/*
			一个类名如果报红就两种情况:
			1:类名没写对
			2:没导报
		 */
		FileInputStream fis
				= new FileInputStream("test.txt");

		//1:类名没有拼写正确
		//2:类使用错误，应当使用输出流
//		FileInputStream fos
//				= new FIleInputStream("test_cp.txt");

		FileOutputStream fos
				= new FileOutputStream("test_cp.txt");

		int d;
		while ((d = fis.read()) != -1) {
			//不能在循环中连续调用两次read()
//			fos.write(fis.read());
			fos.write(d);
		}
		System.out.println("复制完毕!");
		fis.close();
		fos.close();
	}
}




