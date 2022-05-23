package reflect;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 利用反射机制实例化对象
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println(p);

        /*
            1:加载要实例化类的类对象
            2:通过类对象实例化
         */
//        //1加载Person的类对象
//        Class cls = Class.forName("reflect.Person");
//        //2实例化Person
//        Object p2 = cls.newInstance();//该方法会调用Class所表示的类的[无参构造器]实例化对象
//        System.out.println(p2);
        /*
            java.util.ArrayList
            java.util.HashMap
            java.util.Date
            reflect.Person
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名:");
        String className = scanner.nextLine();

        Class cls = Class.forName(className);
        Object o = cls.newInstance();
        System.out.println(o);

    }
}
