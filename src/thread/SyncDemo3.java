package thread;

/**
 * 静态方法上如果使用synchronized修饰，那么该方法一定具有同步效果。
 */
public class SyncDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                Foo.dosome();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                Foo.dosome();
            }
        };
        t1.start();
        t2.start();
    }
}

class Foo{
    public synchronized static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+":正在执行dosome方法...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println(t.getName()+":执行dosome方法完毕!");
    }
}