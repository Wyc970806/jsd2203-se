package reflect;

import java.lang.reflect.Method;

/**
 * 调用有参数方法
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.say("大家好~");
        p.say("大家好呀!",5);

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        //say(String info)
        Method m1 = cls.getMethod("say",String.class);
        m1.invoke(obj,"哈哈哈");//p.say("哈哈哈");

        //say(String info,int count)
        Method m2 = cls.getMethod("say",String.class,int.class);//参数类型，顺序，个数必须与方法一致
        m2.invoke(obj,"嘿嘿嘿",10);//实参的个数，类型，顺序也必须与方法定义一致
    }
}






