package thread;

/**
 * 静态方法上如果使用synchronized修饰，那么该方法一定具有同步效果。
 */
public class SyncDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->Foo.dosome());
        Thread t2 = new Thread(()->Foo.dosome());

        t1.start();
        t2.start();
    }
}

class Foo{
    /*
        静态方法上的同步监视器对象依然不可选,指定的就是当前类的类对象.
        即:Class的实例
        JVM在加载一个类时会同时生成一个Class实例与之对应,每个被JVM加载的类都有
        且只有一个Class的实例,这个实例成为该类的类对象.后面学习反射知识的时候会详细说它
     */
//    public synchronized static void dosome(){
    public static void dosome(){
        //静态方法中如果使用同步块,指定的同步监视器对象通常也是当前类的类对象
        //写法为:当前类类名.class
        synchronized (Foo.class) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在执行dosome方法...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println(t.getName() + ":执行dosome方法完毕!");
        }
    }
}