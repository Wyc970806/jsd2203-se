package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 *  受元素equals方法影响的集合操作
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(2,3));
        c.add(new Point(4,5));
        c.add(new Point(6,7));
        c.add(new Point(8,9));
        c.add(new Point(1,2));
        /*
            集合重写了toString方法，格式为:
            [元素1.toString(), 元素2.toString(), ......]
         */
        System.out.println(c);


        Point p = new Point(1,2);
        /*
            boolean contains(Object o)
            判断当前集合是否包含给定元素o,判断依据是该元素是否与集合现有元素存在
            equals比较为true的，如果存在则认为包含。
         */
        boolean contains = c.contains(p);
        System.out.println("集合是否包含该元素:"+contains);

        /*
            remove方法删除元素时也是删除与集合元素equals比较为true的元素
            注意:对于List集合而言，重复元素仅会删除一次。
         */
        c.remove(p);
        System.out.println(c);



    }
}




