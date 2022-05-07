package thread;

/**
 * Thread提供了一套获取线程相关信息的方法(了解即可)
 */
public class ThreadInfoDemo {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();//获取主线程

        String name = main.getName();//获取线程的名字
        System.out.println("名字:"+name);
        /*
            唯一标识:
            用该值唯一表达一个数据。区分你我的。
            可以作为唯一标识使用的值必须同时满足两个要求:非空且唯一
         */
        long id = main.getId();//获取线程的唯一标识
        System.out.println("id:"+id);

        int priority = main.getPriority();//获取线程的优先级，整数:1-10
        System.out.println("优先级:"+priority);

        boolean isAlive = main.isAlive();//线程是否还活着
        System.out.println("isAlive:"+isAlive);

        boolean isDaemon = main.isDaemon();//线程是否为守护线程
        System.out.println("isDaemon"+isDaemon);//主线程不是守护线程

        boolean isInterrupted = main.isInterrupted();//线程是否被中断了
        System.out.println("isInterrupted:"+isInterrupted);

    }
}








