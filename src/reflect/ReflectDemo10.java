package reflect;

import java.lang.reflect.Method;

/**
 * 在反射机制中获取注解的参数
 */
public class ReflectDemo10 {
    public static void main(String[] args) throws Exception {
        //根据@AutoRunMethod上的参数值作为我们自动调用方法的次数
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(AutoRunMethod.class)){
                //当我们确定一个方法被特定的注解标注后，就可以获取该注解从而得到注解中传递的参数
                AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                int value = arm.value();//获取该方法上@AutoRunMethod注解上传递的参数值
                System.out.println(method.getName()+":注解@AutoRunMethod中指定的参数value的值为:"+value);
                for(int i=0;i<value;i++){
                    method.invoke(obj);
                }
            }
        }

    }
}
