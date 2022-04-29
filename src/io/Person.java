package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 标准的JAVA BEAN规则
 * 应当有无参构造器
 * 属性应当有对应的get，set方法
 *
 * Person : 人
 *
 * 使用当前类的实例测试对象流的序列化与反序列化操作
 * 序列化:将一个对象按照其结构转化为一组字节的过程
 * 反序列化:将一组字节还原为一个对象的过程
 */
public class Person implements Serializable {
    /*
        当一个类实现了可序列化接口后，建议明确添加序列化版本号。
        这样当我们进行对象的反序列化时，如果当前类的结构改变了(比如新添加了属性)
        由于版本号没有改变，那么反序列化就可以成功。
        如果不指定序列化版本号，那么对象在序列化时对象输出流会根据当前类结构生成
        一个版本号，但是缺点是只要当前类结构改变了，版本号也会一同变化，这会导致
        之前序列化的对象都无法反序列化成功，会抛出异常:java.io.InvalidClassException

        建议通读文档
        Serializable接口的描述
     */
    public static final long serialVersionUID = 1L;
    private String name;//名字
    private int age;//年龄
    private String gender;//性别
    /*
        被关键字:transient修饰的属性，对象序列化时该属性的值会被忽略。
        忽略不必要的属性可以达到的对象序列化"瘦身"的目的,减小不必要的开销。
     */
    private transient String[] otherInfo;//其它信息

//    private int salary;

    public Person(){}

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}
