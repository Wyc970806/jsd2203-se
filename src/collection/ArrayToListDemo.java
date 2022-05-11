package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为List集合
 * 数组的工具类Arrays提供了一个静态方法asList,可以将一个数组转换为一个List集合
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        System.out.println("array:"+ Arrays.toString(array));

        List<String> list = Arrays.asList(array);
        System.out.println("list:"+list);
        /*
            对该集合的操作就是对原数组对应的操作
         */
        list.set(1,"six");
        System.out.println("list:"+list);
        System.out.println("array:"+ Arrays.toString(array));
        /*
            由于数组是定长的，因此对该集合的增删操作会导致抛出下列异常
            java.lang.UnsupportedOperationException
                      不支持      操作
         */
//        list.add("seven");

//        array[3] = "seven";
//        System.out.println("array:"+ Arrays.toString(array));
//        System.out.println("list:"+list);


        /*
            所有的集合都支持一个参数为Collection的构造器，作用是创建当前集合的同时包含给定集合中的
            所有元素。
         */
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
        list2.add("seven");
        System.out.println(list2);

    }
}
