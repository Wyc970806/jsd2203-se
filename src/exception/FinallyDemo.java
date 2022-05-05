package exception;

/**
 * finally块是异常处理机制的最后一块。
 * 它可以直接跟在try语句块之后或者最后一个catch块之后。
 *
 * finally的特点是:只要程序执行到try语句块中，无论try中代码是否出现异常，最终finally都必定执行。
 * 通常我们会将释放资源这类操作放到finally中确保执行。比如IO操作后的close方法调用。
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try{
//            String str = null;
            String str = "abc";
            System.out.println(str.length());
            return;
        }catch(Exception e){
            System.out.println("出现了错误");
        }finally{
            System.out.println("finally中的代码执行了!");
        }
        System.out.println("程序结束了");
    }
}
