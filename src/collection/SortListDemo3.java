package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序字符串
 * 当排序的集合元素已经实现了Comparable接口，自身是可以比较的元素，但是该比较规则不
 * 满足我们排序需求时，我们也可以提供额外的比较规则来进行排序
 */
public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("jack");
//        list.add("rose");
//        list.add("jill");
//        list.add("tom");
//        list.add("jerry");
//        list.add("HanMeiMei");
//        list.add("LiLei");
//        list.add("james");
//        list.add("Ada");
//        list.add("kobe");


        list.add("苍老师");
        list.add("传奇");
        list.add("小泽老师");

        System.out.println(list);
//        Collections.sort(list);

        //按照字数的多少排序
//        Collections.sort(list,(s1,s2)->s1.length()-s2.length());

        /*
            JDK8之后List集合本身也提供了sort方法，可以直接排序当前集合。
         */
        list.sort((s1,s2)->s1.length()-s2.length());

        System.out.println(list);


    }
}
