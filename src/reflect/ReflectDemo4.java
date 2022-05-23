package reflect;

import java.lang.reflect.Method;

/**
 * 利用反射机制调用方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.sayHello();

        /*
            利用反射机制进行上述操作的步骤:
            1:获取类对象
            2:实例化对象
            3:通过类对象获取要调用的方法对象
            4:利用方法对象进行方法的调用
         */
        //Person p2 = new Person();
        Class cls = Class.forName("reflect.Person");
        Object p2 = cls.newInstance();

        /*
            Class提供了获取其表示的类中某个特定的方法的操作:
            Method getMethod(String methodName,Class... argsType)
            参数1:方法名
            参数2:实参列表。当获取的方法没有参数时，这里可以省略。
         */
        //p2.sayHello();
        Method method = cls.getMethod("sayHello");//通过类对象获取Person的成员方法sayHello()
        /*
            Method对象提供了调用该方法的操作:
            Object invoke(Object obj,Object[] args)
            参数1:当前Method对象表示的方法的所属对象
            参数2:该方法的实参列表
            返回值:实际调用该方法后该方法的返回值。
         */
        method.invoke(p2);
    }
}









