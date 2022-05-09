package thread;

/**
 * 同步块
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能提高并发效率。
 *
 * 语法:
 * synchronized(同步建设机器对象){
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
    public synchronized void buy(){
        try {
            Thread t = Thread.currentThread();//获取执行buy方法的线程
            System.out.println(t.getName()+":正在挑衣服...");
            Thread.sleep(5000);

            System.out.println(t.getName()+":正在试衣服...");
            Thread.sleep(5000);

            System.out.println(t.getName()+":结账离开");
        } catch (InterruptedException e) {
        }
    }
}





