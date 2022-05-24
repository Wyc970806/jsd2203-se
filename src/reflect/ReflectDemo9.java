package reflect;

import java.lang.reflect.Method;

public class ReflectDemo9 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");

        //获取Person类中定义的所有方法(本类定义的，不包含从超类继承的)
        Method[] methods = cls.getDeclaredMethods();

        //输出被@AutoRunMethod标注的方法名
        for(Method method : methods){
            if(method.isAnnotationPresent(AutoRunMethod.class)){
                System.out.println(method.getName()+":被标注了!");
            }else{
                System.out.println(method.getName()+":没有被标注");
            }
        }


    }
}
