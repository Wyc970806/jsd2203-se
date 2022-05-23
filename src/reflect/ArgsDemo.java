package reflect;

import java.util.Arrays;

/**
 * JDK5版本推出时推出的一个特性:变长参数
 */
public class ArgsDemo {
    public static void main(String[] args) {
        //编译后对应变长参数的部分全部转换为一个数组
        dosome();//dosome(new String[]{})
        dosome("1");//dosome(new String[]{"1"})
        dosome("1","2");//dosome(new String[]{"1","2"})
        dosome("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16");//dosome(new String[]{"1","2",..."16"})
    }
    public static void dosome(String... s){
//    public static void dosome(String[] s){//编译后s是一个数组

        System.out.println(s.length);
        System.out.println(Arrays.toString(s));
    }

}
