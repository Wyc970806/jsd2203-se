package thread;

/**
 * 同步块
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能提高并发效率。
 *
 * 语法:
 * synchronized(同步监视器对象){
 *     需要同步执行的代码片段
 * }
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread("范传奇"){
            public void run(){
                shop.buy();
            }
        };
        Thread t2 = new Thread("王克晶"){
            public void run(){
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop{
//    public synchronized void buy(){
    public void buy(){
        try {
            Thread t = Thread.currentThread();//获取执行buy方法的线程
            System.out.println(t.getName()+":正在挑衣服...");
            Thread.sleep(5000);
            /*
                同步块可以更精准的控制需要多个线程同步执行的代码片段，这里需要在"()"
                中指定同步监视器对象，该对象可以是任何引用类型(语法层面上)，但是要想
                让多个线程同步执行该同步块，必须保证这些线程看到的这个同步监视器对象
                是【同一个】才行!
             */
            synchronized (this) {
                System.out.println(t.getName() + ":正在试衣服...");
                Thread.sleep(5000);
            }

            System.out.println(t.getName()+":结账离开");
        } catch (InterruptedException e) {
        }
    }
}





