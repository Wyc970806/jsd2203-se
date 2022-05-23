package reflect;

import java.lang.reflect.Method;

/**
 * 操作属性
 */
public class ReflectDemo7 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println(p);
        p.setAge(70);//实际开发中，我们几乎不会对属性直接操作，都是借助于属性提供的get,set方法进行的。
        System.out.println(p);

        Class cls = Class.forName("reflect.Person");
        Object o = cls.newInstance();
        System.out.println(o);
        //设置名字
        Method method = cls.getMethod("setName",String.class);//setName(String name)
        method.invoke(o,"李四");//o.setName("李四")
        System.out.println(o);
    }
}
