package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java集合框架
 * java.util.Collection接口。java中所有的集合都实现了它。
 * 该接口中规定了所有集合都必须具备的功能。
 *
 * 集合与数组一样，可以保存一组元素，但是对于元素的操作全部提供成了方法
 * 使用更方便，并且集合有多种不同的数据结构。
 *
 * Collection下面有两个比较常用的子类型:
 * java.util.List接口，List集合的特点是可以存放重复元素且有序。一般也称为线性表。
 * java.util.Set接口，Set集合的特点是不能存放重复元素。
 *
 * 重复元素的标准是根据元素自身equals比较的结果，当equals比较为true的两个元素就认为是重复元素
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        /*
            集合仅能存放引用类型元素!
         */
        /*
            boolean add(E e)
            向集合中添加一个元素，如果该元素成功添加到集合中则返回true
         */
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        /*
            int size()
            返回当前集合的元素个数
         */
        int size = c.size();
        System.out.println("size:"+size);

        /*
            boolean isEmpty()
            判断当前集合是否为空集.当且仅当size为0时，isEmpty为true
         */
        boolean isEmpty = c.isEmpty();
        System.out.println("isEmpty:"+isEmpty);

        /*
            void clear()
            清空集合
         */
        c.clear();
        System.out.println(c);
        System.out.println("size:"+c.size());
        System.out.println("isEmpty:"+c.isEmpty());


    }
}
