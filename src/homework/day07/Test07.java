package homework.day07;

import java.util.Arrays;

/**
 * 分析并指定合适的锁对象，使得下面的代码成立
 *
 * @author Xiloer
 */
public class Test07 {
    public static void main(String[] args) throws InterruptedException {
        Goo goo1 = new Goo();
        Goo goo2 = new Goo();
        Thread t1 = new Thread() {
            public void run() {
				synchronized (goo1) {
                    for (int i = 0; i < 100; i++) {
                        goo1.array = Arrays.copyOf(goo1.array, goo1.array.length + 1);
                        goo1.array[goo1.array.length - 1] = i;
                    }
				}
            }
        };
        Thread t2 = new Thread() {
            public void run() {
				synchronized (goo1) {
                    for (int i = 100; i < 200; i++) {
                        goo1.array = Arrays.copyOf(goo1.array, goo1.array.length + 1);
                        goo1.array[goo1.array.length - 1] = i;
                    }
				}
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                synchronized (goo2) {
                    for (int i = 0; i < 100; i++) {
                        goo2.array = Arrays.copyOf(goo2.array, goo2.array.length + 1);
                        goo2.array[goo2.array.length - 1] = i;
                    }
                }
            }
        };
        Thread t4 = new Thread() {
            public void run() {
                synchronized (goo2) {
                    for (int i = 100; i < 200; i++) {
                        goo2.array = Arrays.copyOf(goo2.array, goo2.array.length + 1);
                        goo2.array[goo2.array.length - 1] = i;
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        /*
         * 多执行几次，检查程序可能存在的问题，并尝试自己
         * 分析为什么会出现这些情况?
         *
         * 两个线程各自对数组扩容了100次，按理说数组应当
         * 有200的长度，并且里面存放着数据才是对的。数据
         * 的位置无所谓，毕竟是并发的。
         */
        Thread.sleep(1000);//阻塞1秒是等待上面两个线程干完活
        System.out.println(goo.array.length);
        System.out.println(Arrays.toString(goo.array));
    }
}
class Goo{
    public int[] array = {};
}