package thread;

/**
 * 睡眠阻塞
 * Thread提供了一个静态方法:
 * static void sleep(long ms)
 * 使运行该方法的线程阻塞指定毫秒
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");
        /*
            倒计时程序  github.com
            程序启动后要求在控制台上输入一个数字，然后从该数字开始每秒递减。到0时输出时间到。
         */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("程序结束了!");
    }
}




