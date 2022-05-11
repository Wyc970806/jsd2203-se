package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 集合转换为数组
 * Collection上提供了一个方法:toArray,可以将当前集合转换为一个数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
//        Object[] array = c.toArray();//不建议使用了
        /*
            传入的数组类型应当与集合元素类型一致。而数组长度没有要求。
            toArray的原则是传入的数组能用(length>=size)时就直接使用该数组
            否则自行创建一个与集合size一样长，类型与传入的数组类型一致的数组并返回
         */
//        String[] array = c.toArray(new String[c.size()]);
//        String[] array = c.toArray(new String[10]);
        String[] array = c.toArray(new String[1]);
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));


    }
}
