package homework.day07;

import java.util.Date;

/**
 * 计时器功能
 * 要求每秒输出一次当前系统时间
 * 
 * 额外小知识，java.util.Date类的每一个实例用于表示一个时间点，
 * 默认创建表示当前系统时间。
 * 
 * 单词记一记:
 * now 现在
 * date 日期
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//首先运行，查看Date输出
		Date now = new Date();
		System.out.println(now);
	}
}
