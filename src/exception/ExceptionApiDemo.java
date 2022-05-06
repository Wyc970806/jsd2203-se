package exception;

/**
 * 异常常见方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String line = "abc";
            System.out.println(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            /*
                e.printStackTrace()该方法内部使用System.err输出的错误信息。
                即:System.err.println("");

                而它和System.out都是向控制台进行输出，只不过前者专门用来输出错误信息
                并且两个输出流是并发运行的，因此输出可能存在先后顺序的误差。

             */
            e.printStackTrace();//输出错误堆栈信息的，以便我们去debug
            /*
                String getMessage()
                返回当前异常的错误消息，通常有两个用途:
                1:用来给用户做提示信息
                2:用来做日志的记录使用
             */
            String message = e.getMessage();
            System.out.println("message:"+message);
//
        }
        System.out.println("程序结束了");
    }
}
