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
        /*
            如果执行下面代码会抛出异常:java.io.EOFException
            EOF:end of file 文件的末尾
            意味着如果使用对象流读取文件时在没有读取完一个对象的所有数据就已经达到
            文件末尾时会抛出该异常。
            这里的原因是:
            上面已经执行了readObject将文件中的对象数据都读取完毕经还原了
            然后下面有执行一次readObject,此时文件中已经没有数据了，所以会抛出
            文件末尾异常
         */
//        System.out.println(ois.readObject());
        System.out.println(person);

        ois.close();

    }
}
