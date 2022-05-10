package homework.day07;

/**
 * 修改下面代码的编译
 *
 * @author Xiloer
 */
public class Test05 {
    public static void main(String[] args) {
        //错误是没有重写run方法来定义线程任务
//		Thread t1 = new Thread() {
//			Foo.dosome();
//		};
//		Thread t2 = new Thread() {
//			Foo.dosome();
//		};

        Thread t1 = new Thread() {
            public void run() {
                Foo.dosome();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                Foo.dosome();
            }
        };
		t1.start();
		t2.start();
    }
}
class Foo{
	public static void dosome() {
        //静态方法中看不到this
//		synchronized (this) {
        synchronized (Foo.class) {
			System.out.println("hello!");
		}
	}
}