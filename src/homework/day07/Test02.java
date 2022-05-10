package homework.day07;
/**
 * 修改下面的错误
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		/*
			1:"->"写法有错误
			2:Thread不可以用lambda表达式创建，Runnable可以。
		 */

//		Thread t1 = ()—>{
		Thread t1 = new Thread(()->{
			System.out.println("你是谁?");
		});

//		Thread t2 = new Thread(
//			()—>System.out.println("我是查水表的!")
//		);

		Thread t2 = new Thread(
				()->System.out.println("我是查水表的!")
		);

		t1.start();
		t2.start();
	}
}



