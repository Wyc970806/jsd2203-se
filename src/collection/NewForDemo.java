package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
 *
 *
 * JDK5推出的另一个特性:泛型
 * 泛型也称为参数化类型，允许我们在使用一个类时通过泛型指定一个类中某个属性，或方法的参数，
 * 或方法返回值的类型。使得我们使用更灵活。
 * 泛型在集合中被广泛使用，用来指定集合中的元素类型。
 *
 *
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
        /*
            泛型只能定义为引用类型。对于基本类型而言必须指定为其对应的包装类
         */
        Collection<String> c = new ArrayList<>();
        c.add("一");//add(E e)，编译器会当E为String类型检查实参
        c.add("二");
        c.add("三");
        c.add("四");
        c.add("五");
//        c.add(123);//实参不符合泛型要求时编译不通过。

        /*
            新循环遍历会被编译器改回成迭代器遍历
         */
        for(String str : c){
            System.out.println(str);
        }

        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
    }
}




