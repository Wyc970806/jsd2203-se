package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 使用对象输入流反序列化对象
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
            对象输入流提供了一个独有的方法:
            Object readObject()
            作用是先通过其链接的流读取一组字节，然后将其还原为对应的java对象并返回。
            返回时统一以Object形式返回，所以实际接收后可造型为实际类型去使用。
         */
        Person person = (Person)ois.readObject();
        System.out.println(person);

        ois.close();

    }
}
