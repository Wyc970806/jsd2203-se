package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5之后推出了一个新的特性:增强型for循环
 * 也称为新循环。它是专门用来遍历集合或数组的。
 *
 * 语法:
 * for(元素类型 变量名 : 遍历的集合或数组){
 *     ...
 * }
 *
 * 注意:新循环的语法是编译器认可的而非虚拟机
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        for(int i=0;i<array.length;i++){
            String str = array[i];
            System.out.println(str);
        }
        //新循环会被编译器改为普通for循环遍历
        for(String str : array){
            System.out.println(str);
        }

        Collection c = new ArrayList();
        c.add("一");
        c.add("二");
        c.add("三");
        c.add("四");
        c.add("五");
        for(Object o : c){
            String str = (String)o;
            System.out.println(str);
        }

    }
}




