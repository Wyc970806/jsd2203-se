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

        String str = null;
        System.out.println(str.length());

        System.out.println("程序结束了...");
    }
}





