package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *  JAVA Reflect 反射机制
 *  反射是java的动态机制，允许我们在程序[运行期间]再确定对象的实例化，属性的操作，方法的调用等。
 *  反射机制可以提高代码的灵活度，但同时带来了更多的资源开销和较慢的运行效率，因此不能过度依赖。
 */
public class ReflectDemo1 {
    public static void main(String[] args) {
       /*
            反射机制第一步:在程序运行期间获取要操作的类的类对象。
            类对象:Class类的实例
            JVM加载一个类时，就会实例化一个Class的实例与其绑定，并且这个Class实例中会记录加载的类的一切信息:
            类名，包名，属性，方法，构造器。

            获取一个类的类对象的方式:
            1:类名.class
            比如:
                Class cls = String.class;
                Class cls = int.class;
                注意:基本类型获取对应的类对象，只有这一种方式。

            2:Class.forName(String className)
            比如:
                Class cls = Class.forName("java.lang.String")
                注意:参数要求传入的是对应类的完全限定名:包名.类名

            3:ClassLoader方式加载
        */

        //获取String的类对象
//        Class cls = String.class;
        Class cls = ArrayList.class;

        //获取类名
        String name = cls.getName();//获取完全限定名
        System.out.println(name);

        name = cls.getSimpleName();//仅获取类名
        System.out.println(name);

        //获取包名
        String packageName = cls.getPackage().getName();
        System.out.println(packageName);
        /*
            Class称为类对象

            Method称为方法对象，该类的每一个实例用于表示一个方法，该对象上记录这其表示的方法里的所有信息
            如:方法的访问修饰符，返回值类型，方法名，参数列表信息等。
         */
        Method[] methods = cls.getMethods();
        for(Method method : methods){
            String methodName = method.getName();//获取方法名
            System.out.println(methodName);
        }

    }



}






