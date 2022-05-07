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

        t1.start();
        t2.start();

    }
}
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





