package thread;

/**
 * Thread提供了一个方法interrupt().称为中断方法。而该方法主要作用就是中断某个线程的阻塞状态。
 * 而通常会导致线程阻塞的方法都要求处理中断异常，就是当一个线程处于阻塞时，如果该线程的interrupt方法被
 * 调用导致阻塞状态被中断时抛出该异常。
 * sleep方法就是如此。
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
            public void run(){
                System.out.println("林:刚美完容，睡一会吧~~");
                try {
                    Thread.sleep(500000000);
                } catch (InterruptedException e) {
                    System.out.println("林:干嘛呢~干嘛呢~干嘛呢~都破了相了!");
                }
                System.out.println("林:醒了");
            }
        };

        Thread huang = new Thread(){
            public void run(){
                System.out.println("黄:大锤80，小锤40，开始砸墙!");
                for(int i=0;i<5;i++){
                    System.out.println("黄:80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("咣当!");
                System.out.println("黄:大哥，搞定!");
                lin.interrupt();//中断lin线程的阻塞状态
            }
        };

        lin.start();
        huang.start();


    }
}
