package thread;

/**
 * 使用匿名内部类完成线程的两种创建方式
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //第一种创建方式:继承Thread重写run方法
        Thread t1 = new Thread(){
            public void run(){
                for(int i=0;i<1000;i++){
                    System.out.println("你是谁啊?");
                }
            }
        };
        //第二种创建方式:实现Runnable接口重写run方法
//        Runnable r2 = new Runnable(){
//            public void run(){
//                for(int i=0;i<1000;i++){
//                    System.out.println("我是查水表的!");
//                }
//            }
//        };
//        Thread t2 = new Thread(r2);

        Thread t2 = new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println("我是查水表的!");
            }
        });

        t1.start();
        t2.start();
    }
}





