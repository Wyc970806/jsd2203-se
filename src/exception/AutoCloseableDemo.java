package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，java推出了一个新的特性:自动关闭
 * 语法:
 * try(
 *      定义并初始化需要在finally中调用close关闭的类实例
 * ){
 *
 * }catch(XXXException e){
 *
 * }
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try(
                //只有实现了AutoCloseable接口的类才可以在这里定义，并最终编译器会改为在finally中调用close()
                //编译后的代码参照FinallyDemo2的样子
                FileOutputStream fos = new FileOutputStream("fos.dat");
                //String没有实现该接口，不能在这里定义
//                String str = "abc";
        ){
            fos.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
