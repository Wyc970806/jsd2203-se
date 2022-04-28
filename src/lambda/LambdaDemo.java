package lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * lambda表达式是JDK8之后推出的一个特性
 * 可以用更精简的语法创建匿名内部类
 * 语法:
 * (参数列表)->{
 *     方法体
 * }
 * lambda表达式不是所有匿名内部类都可以被替代，要求是实现的接口只能有一个抽象方法时
 * 才能使用lambda表达式
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //定义文件过滤器  匿名内部类写法
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        };
        //lambda表达式是编译器认可的，编译成字节码文件时会被编译器改回成内部类创建
        FileFilter filter1 = (File file)->{
                return file.isFile();
        };
        //lambda表达式允许忽略参数类型
        FileFilter filter2 = (file)->{
            return file.isFile();
        };
        //lambda表达式如果方法体中只有一行代码，那么方法体的{}可以不写,如果这句代码含有return,那么return必须一同省略。
        FileFilter filter3 = (f)->f.isFile();

    }
}
