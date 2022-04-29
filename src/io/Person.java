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
    private String name;//名字
    private int age;//年龄
    private String gender;//性别
    private String[] otherInfo;//其它信息

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
