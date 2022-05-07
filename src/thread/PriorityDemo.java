package thread;

/**
 * 线程的优先级
 * 当一个线程调用start方法后就纳入到了线程调度器中被统一管理。此时线程只能被动被分配CPU时间片来得以并发运行。
 * 线程不能主动索取时间片，调度器会尽可能均匀的分配时间片给每一个线程，但是不保证"一人一次"。
 * 调整线程的优先级可以最大程度改善获取时间片的概率。原则上优先级越高的线程获取时间片的次数越多。
 *
 * 线程的优先级分为10个等级，以整数1-10表示。其中1为最低优先级，5为默认优先级，10为最高优先级。
 * 可以通过线程提供的方法setPriority()进行设置。
 *
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println("min");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println("max");
                }
            }
        };
        Thread norm = new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println("nor");
                }
            }
        };
//        min.setPriority(1);
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        norm.start();
        max.start();


    }
}








