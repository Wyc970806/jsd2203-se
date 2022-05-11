package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合之间的操作
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1:"+c1);
        Collection c2 = new ArrayList();
        c2.add("ios");
        c2.add("android");
        System.out.println("c2:"+c2);
        /*
            boolean addAll(Collection c)
            将给定集合中的所有元素添加到当前集合中
         */
        c1.addAll(c2);
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
    }
}








