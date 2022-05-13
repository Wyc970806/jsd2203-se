package map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * JDK8之后，集合与Map都提供了一个方法forEach()，可以基于lambda表达式遍历
 */
public class MapDemo3 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        /*
            forEach方法中传入的lambda表达式会被调用若干次(取决于集合的元素个数)，
            每调用一次lambda，参数e表示集合中的一个元素。
         */
//        c.forEach((e)->{
//            System.out.println(e);
//        });

//        Consumer<String> con = new Consumer<String>() {
//            public void accept(String e) {
//                System.out.println(e);
//            }
//        };
//        c.forEach(con);

//        c.forEach(e->System.out.println(e));
        /*
            如果lambda表达式中参数正好用于方法体调用的方法所使用的参数
            例如下面的代码:
            lambda表达式参数e正好被用于lambda表达式方法体中的代码:
            System.out.println(e)中的参数

            此时可以使用lambda表达式的变种写法:方法引用
            System.out::println
         */
//        c.forEach(e->System.out.println(e));
        c.forEach(System.out::println);


    }
}
