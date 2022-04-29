package io;

import java.io.*;

/**
 * 对象流java.io.ObjectOutputStream和ObjectInputStream
 * 对象流是一对高级流，功能是进行对象序列化与反序列化。方便我们读写java对象
 *
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        //将一个Person对象写入文件保存
        String name = "苍老师";
        int age = 18;
        String gender = "女";
        String[] otherInfo = {"身高168","是个演员","来自日本","88,90","是我们的启蒙老师"};
        Person p = new Person(name,age,gender,otherInfo);
        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
            ObjectOutputStream提供了一个独有的序列化对象的方法:
            void writeObject(Object obj)
            该方法会将给定的对象按照其结构转换为一组字节并通过其链接的流将字节写出。

            如果该方法抛出异常:
            java.io.NotSerializableException
            则说明给定的对象没有实现序列化接口:java.io.Serializable
            还要求该类中所有的引用类型属性也需要实现该接口
            常用的数据类型:
            String,包装类,数组等都实现可序列化接口
         */
        oos.writeObject(p);

        System.out.println("写出完毕!");
        oos.close();

    }
}
