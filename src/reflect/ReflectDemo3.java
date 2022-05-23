package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用有参构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person p = new Person("李四",22);
        System.out.println(p);

        //1获取类对象
        Class cls = Class.forName("reflect.Person");
        /*
            2通过类对象获取特定的构造器
            Constructor:构造器

            Class提供的获取特定构造器的方法:
            Constructor getConstructor(Class... argsType)
            要将特定构造器的参数类型对应的类对象有序传入即可

            java.lang.reflect.Constructor构造器对象，该类的每一个实例表示一个构造器
         */
        //获取 Person(String,int)
        Constructor c = cls.getConstructor(String.class,int.class);

        //3利用构造器实例化对象
        Object obj = c.newInstance("王五",33);//new Person("王五",33);
        System.out.println(obj);

    }
}
