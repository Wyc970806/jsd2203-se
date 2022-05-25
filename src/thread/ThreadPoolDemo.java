package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 主要解决两个问题:
 * 1:控制线程数量
 * 2:重用线程
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个固定大小的线程池，线程数量为2
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            Runnable r = new Runnable() {
                public void run() {
                    Thread t = Thread.currentThread();//获取运行当前任务的线程
                    System.out.println(t.getName()+":正在执行任务...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("线程被中断了！");
                    }
                    System.out.println(t.getName()+":执行任务完毕!");
                }
            };
            threadPool.execute(r);//将任务交给线程池
            System.out.println("将一个任务交给线程池...");
        }

//        threadPool.shutdown();//不再接收新任务，并将线程池中已经存在的所有任务执行完毕后停止
        threadPool.shutdownNow();//立即调用所有内部线程的interrupt()方法试图中断所有线程使线程池立即停止
        System.out.println("线程池关闭了!");


    }
}
