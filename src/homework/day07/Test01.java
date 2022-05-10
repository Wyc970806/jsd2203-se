package homework.day07;
/**
 * 改正下面程序的错误,使得程序可以正常运行
 * 
 * 使用第二种创建线程方式创建一条线程，并输出100次:你好
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		MyRunnable run = new MyRunnable();
//		Thread t = new Thread();
		Thread t = new Thread(run);//需要将任务传入给线程
		t.start();
	}
}
//没有实现Runnable接口
//class MyRunnable{
class MyRunnable implements Runnable{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("你好!");
		}
	}
}




