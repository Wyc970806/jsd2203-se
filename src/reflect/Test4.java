package reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

/**
 * 自动调用那些与当前类Test4在同一个包中被@AutoRunClass标注的类中那些被@AutoRunMethod标注的方法
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        File dir = new File(
                Test4.class.getResource(".").toURI()
        );
        File[] files = dir.listFiles(f->f.getName().endsWith(".class"));
        for(File file : files){
            String fileName = file.getName();
            String className = fileName.substring(0,fileName.indexOf("."));
            Class cls = Class.forName(Test4.class.getPackage().getName()+"."+className);
            if(cls.isAnnotationPresent(AutoRunClass.class)) {
                Object o = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        method.invoke(o);
                    }
                }
            }
        }
    }
}
