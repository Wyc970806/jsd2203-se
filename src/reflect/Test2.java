package reflect;

import java.io.File;
import java.lang.reflect.Method;

/**
 *  自动调用reflect包中那些含有名字以s开头的无参方法的类中对应的这些方法
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        /*
            确定的几个问题?
            1:怎么确定reflect包下有多少给类?
              因为要分析一个类是否有s开头的无参方法，前提是我们要先获取到该类的类对象
              Class.forName("包名.类名")
              这里的包名咱们确定了，就是"reflect"
              类名怎么确定呢?

            思路:
            java要求:源文件或编译后的字节码文件它的文件名必须与其中的类名一致
            好比:public class Test{...}
            对应的源文件名:Test.java
            对应的字节码文件名:Test.class

            利用File定位保存所有字节码文件的目录reflect.
            获取该目录下的所有字节码文件。
            再根据每个字节码文件的文件名来确定reflect包下所有类的名字
            再利用Class.forName()就可以加载了
         */
        //确定目录
        File dir = new File("./src/reflect");
        //获取该目录下的所有源文件(.java文件)
        File[] files = dir.listFiles(f->f.getName().endsWith(".java"));
        for(File file : files){
//            System.out.println(file.getName());
            //通过文件名截取类名
            String fileName = file.getName();//文件名
            String className = fileName.substring(0,fileName.indexOf("."));// fileName.split("\\.")
//            System.out.println(className);
            //加载类对象
            Class cls = Class.forName("reflect."+className);
            Object o = cls.newInstance();
            Method[] methods = cls.getDeclaredMethods();
            for(Method method : methods){
                if(method.getName().startsWith("s")&&method.getParameterCount()==0){
                    method.invoke(o);
                }
            }

        }
    }
}
