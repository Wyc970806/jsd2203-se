package thread;

/**
 * java中所有的代码都是靠线程运行的，main方法也不例外。
 * 执行main方法的线程是由JVM创建的，用来执行main方法，该线程的名字也叫"main"，所以我们通常称它为主线程。
 * 该线程没有什么特别之处，与我们创建的线程是一样的。
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        /*
            Thread提供了一个静态方法:
            static Thread currentThread()
            该方法可以获取运行这个方法的线程。
         */
        Thread main = Thread.currentThread();//主线程调用main方法就执行了这句话，方法就获取了主线程
        System.out.println("主线程:"+main);
        dosome();//主线程执行dosome方法

    }
    public static void dosome(){
        Thread t = Thread.currentThread();//获取运行dosome方法的线程
        System.out.println("执行dosome方法的线程是:"+t);
    }
}
