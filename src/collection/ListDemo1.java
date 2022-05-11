package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合
 * java.util.List接口，继承自Collection
 * List集合的特点是:可以存放重复元素且有序
 * List集合提供了一组独有方法，特点是可以通过下标进行操作。
 *
 * List接口下面有两个常用的实现类:
 * java.util.ArrayList:内部使用数组实现，查询性能更好。
 * java.util.LinkedList:内部使用链表实现，首尾增删性能更好。
 *
 * 在没有对性能有特别苛刻的要求时，通常首先ArrayList即可
 *
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
            E get(int index)
            获取给定下标处对应的元素
         */
        String e = list.get(2); //与数组:String e = list[2];功能一致。
        System.out.println(e);

        //List集合可以通过下标遍历
        for(int i=0;i<list.size();i++){
            e = list.get(i);
            System.out.println(e);
        }

        /*
            E set(int index,E e)
            将给定元素e设置到指定下标index处。返回值为集合index处被替换的元素
            实际上就是做替换元素操作。
         */
        System.out.println(list);
        String old = list.set(2,"six");
        System.out.println(list);
        System.out.println(old);


        /*
            将集合list元素反转
         */
        for(int i=0;i<list.size()/2;i++){
//            String s = list.get(i);//获取正数位置上的元素
//            s = list.set(list.size()-1-i,s);//将正数位置上的元素设置到倒数位置上
//            list.set(i,s);//将原倒数位置上的元素设置到正数位置上

            list.set(i,list.set(list.size()-1-i,list.get(i)));
        }

        System.out.println(list);//[five,four,six,two,one]

    }
}
