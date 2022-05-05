package exception;

/**
 * 异常处理机制中的try-catch
 * 语法:
 * try{
 *     可能出现异常的代码片段
 * }catch(XXXException e){
 *     try语句块中出现XXXException后的处理代码
 * }
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");
        //try语句块不可以单独写，后面必须跟catch或finally
        try {
            String str = null;
            //出现空指针后JVM会实例化一个空指针异常实例并抛出
            System.out.println(str.length());
        /*
            如果catch捕获的异常类型是try语句块中出现的错误，JVM就会将异常传
            给变量e,并执行该catch块来来完成补救措施
         */
        }catch(NullPointerException e){
            System.out.println("出现了空指针异常!");
        }
        System.out.println("程序结束了...");
    }
}





