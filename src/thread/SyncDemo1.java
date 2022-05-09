package thread;

/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一临界资源，由于线程切换时机不确定，导致执行顺序出现混乱。严重时可能导致系统瘫痪。
 * 临界资源:操作该资源的完成过程同时只能被单个线程进行。
 *
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread(){
            public void run(){//当一个线程调用自己run方法工作时，如果该方法抛出了一个非检查异常，那么该线程就结束了
                while(true){
                    int bean = table.getBean();
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    int bean = table.getBean();
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };
        t1.start();
        t2.start();
    }
}
class Table{
    private int beans = 20;//桌子上有20个豆子

    /**
     *  当一个方法使用synchronized关键字修饰时，该方法称为"同步方法".即:多个线程不能同时
     *  在该方法中执行。
     *  将并发操作改为同步操作就可有效的解决并发安全问题。
     */
    public synchronized int getBean(){
        if(beans==0){//桌子上没有豆子了
            throw new RuntimeException("没有豆子了!");
        }
        //if执行完毕，在return还没有执行前出现切换可能发生并发安全问题
        Thread.yield();//yield:让出  yield方法的作用是让线程主动让出本次时间片
        return beans--;
    }
}






