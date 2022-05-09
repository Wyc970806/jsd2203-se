package thread;

/**
 * 守护线程
 * 守护线程也称为后台线程。它是通过普通线程(也称为用户线程，前台线程)调用setDaemon(true)设置而转变来的。
 * 因此创建上与普通线程并无差别。
 * 主要差别体现在:进程的结束
 *
 * 进程结束:
 * 当一个java进程中所有普通线程都结束时，进程就会结束，此时它会强行杀死所有还在运行的守护线程。
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for(int i = 0;i<5;i++){
                    System.out.println("rose:let me go!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("rose:啊啊啊啊啊啊啊AAAAAAAAAAAaaaaaaa.......");
                System.out.println("噗通!");
            }
        };

        Thread jack = new Thread(){
            public void run(){
                while(true){
                    System.out.println("jack:you jump! i jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        rose.start();

        jack.setDaemon(true);
        jack.start();
    }
}







