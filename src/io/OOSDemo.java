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
        oos.writeObject(p);

        System.out.println("写出完毕!");

        oos.close();

    }
}
