package reflect;

import java.lang.reflect.Method;

/**
 * 自动调用Person类中所有以s开头的无参方法
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        /*
            提示:
            Method类上有一个方法:
            int getParameterCount()
            返回Method表示的方法对应的参数个数
         */
        /*
            实现思路
            1:获取Person的类对象  提示:Class.forName
            2:实例化             提示:newInstance()
            3:获取Person中定义的所有方法  提示:getDeclaredMethods()
            4:遍历每一个方法，遍历过程中要判断该方法名字是否是以"s"开头，并且方法的参数个数是否为0(无参方法)
              若满足条件则调用该方法
              提示:startsWith()
                   getParameterCount()
                   invoke()
         */
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().startsWith("s")&&
                method.getParameterCount()==0){
                method.invoke(obj);
            }
        }

    }
}
