package thread;

/**
 * 多线程
 *
 * 线程:一个单一的顺序执行流程。
 * 顺序执行:一句代码执行完再执行下一句。
 *
 * 多线程:多个线程一致执行就是多线程。
 * 并发执行:微观世界每个线程的代码都是走走停停的，CPU在这些线程的代码之间快速切换运行，使得它们的"齐头并进"
 *         而宏观感觉是一起执行的效果称为并发执行。
 *
 * 创建线程并发执行多个任务时，线程有两种创建方式:
 * 方式1:
 * 继承Thread并重写run方法，在run方法中定义该线程要执行的任务代码。
 *
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        /*
            注意，启动线程是调用线程的start方法，而不能直接调用run方法!
            当线程的start方法[调用完毕]后，一旦CPU开始执行这个线程的代码
            就会自动调用run方法了。
         */
        t1.start();
        t2.start();

    }
}

/**
 * 这种创建线程的方式优点在于:
 * 结构简单，便于使用匿名内部类创建
 *
 * 缺点:
 * 1:直接继承Thread就无法再继承其它类了，这对实际开发中复用代码不利。
 *   因为java中是单继承的。
 * 2:直接重写run方法，将线程任务定义在了线程中，这导致线程与任务存在
 *   一个必然的耦合关系，不利于线程重用。
 */
class MyThread1 extends Thread{//java.lang.Thread 线程
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("你是谁啊?");
        }
    }
}
class MyThread2 extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("开门，查水表的!");
        }
    }
}





