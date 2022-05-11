package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 *            die
 * 集合的遍历采取迭代器模式.Collection提供了方法:
 * Iterator iterator()
 * 该方法会返回一个用于遍历当前集合的迭代器实现类，用于遍历当前集合元素。
 *
 * java.util.Iterator接口。迭代器接口
 * 迭代器接口规定了迭代器遍历集合的相关操作，不同的集合都提供了一个对应的实现类
 * 来遍历当前集合元素。
 *
 * 迭代器遍历集合遵循的步骤为:问->取->删
 * 其中删除不是必要操作
 *
 *
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println(c);
        Iterator it = c.iterator();
        /*
            boolean hasNext()
            判断集合是否还有"下一个"元素待遍历

            E next()
            获取集合"下一个"元素

            注:迭代器起始位置是集合第一个元素之前
         */
        while(it.hasNext()) {
            String str = (String) it.next();
//            str.xxxx();//实际开发中造型后可以调用对应方法做相关操作
            /*
                迭代器采取快速失败原则，要求:使用迭代器遍历集合的过程中不能通过集合
                的方法增删元素，否则会抛出异常:java.util.ConcurrentModificationException
             */
            if("#".equals(str)){
                c.remove(str);
            }
            System.out.println(str);
        }

        System.out.println(c);//[one,two,three,four,five]
    }
}
