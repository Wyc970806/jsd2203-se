package reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

/**
 * 自动调用与当前类所在同一个包中那些类中方法名以s开头的无参方法。
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        /*
            主体思路与Test2一致。
            唯一要解决的问题是:如何确定Test3在哪个目录?
         */
        /*
            类名.class.getClassLoader().getResource(".")该位置就是当前类的最上层包的上一级。

            例如:
            package reflect;
            public class Test3{...}

            //表示的就是Test3.class文件是在reflect目录里的，而这里是reflect目录的上一级目录
            File dir = new File(
                Test3.class.getClassLoader().getResource(".").toURI()
            );


            表示的就是DispatcherServlet.class文件在core目录里，而core在webserver目录里，
            webserver又在com目录里，所以DispatcherServlet所在包的最上级就是com目录。而
            下面定位就是com的上级目录(com所在的目录)

            package com.webserver.core;
            public class DispatcherServlet{...}

            表示的就是Test3.class文件是在reflect目录里的，而这里是reflect目录的上一级目录
            File dir = new File(
                DispatcherServlet.class.getClassLoader().getResource(".").toURI()
            );

         */

        //应用场景:当想引用与当前类不在一个包中，但都在一个项目中的其他包时，要用该方式
        //总结一句话:定位的就是当前项目下所有类最终存放的目录。
//        File dir = new File(
//            Test3.class.getClassLoader().getResource(".").toURI()
//        );
//        System.out.println(dir);


        //应用场景:当想引用与当前类在在同一个包中的其他类时，可以用该方式
        //总结一句话:当前类对应的字节码文件所在的目录(当前类所在的包)
        File dir = new File(
                Test3.class.getResource(".").toURI()
        );
        System.out.println(dir);
        File[] files = dir.listFiles(f->f.getName().endsWith(".class"));
        for(File file : files){
            String fileName = file.getName();//XXXX.class
            String className = fileName.substring(0,fileName.indexOf("."));
            //因为扫描的是与Test3所在包中的其他类,特点就是这些类的包名与Test3包名一致
            Class cls = Class.forName(Test3.class.getPackage().getName()+"."+className);
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
