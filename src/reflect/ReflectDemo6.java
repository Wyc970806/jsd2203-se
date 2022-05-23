package reflect;

import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
//        p.heihei();//编译不通过，heihei是Person的私有方法，不能在类的外部被调用!

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
        //获取heihei方法
        /*
            通过Class的方法:
            Method getMethod(String methodName)
            获取私有方法时，抛出了异常:java.lang.NoSuchMethodException
                                             No  Such Method
                                             没有 这个 方法
            抛出上述异常一般情况为:
            1:方法名拼错，或者参数列表指定错误
            2:getMethod和getMethods这两个方法【仅能获取该类中所有公开方法(包含从超类继承的)】

         */
//        Method method = cls.getMethod("heihei");
        /*
            Class还提供了对应的方法:
            Method getDeclaredMethod(String method,Class... argsType)
            获取当前类定义的指定方法(可以获取本类定义的私有方法)

            Method[] getDeclaredMethods()
            获取当前类定义的所有方法(不包含从超类继承的)

         */
        Method method = cls.getDeclaredMethod("heihei");
        method.setAccessible(true);//强行打开访问权限，此时下面就不会出现非法访问异常，并可调用私有方法!!!
        /*
            调用私有方法时抛出异常:java.lang.IllegalAccessException
                                         非法    访问
         */
        method.invoke(obj);
    }
}
