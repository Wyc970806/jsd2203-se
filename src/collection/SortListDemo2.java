package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        //Element 元素
        List<Point> list = new ArrayList<>();
        list.add(new Point(5,6));
        list.add(new Point(15,12));
        list.add(new Point(7,9));
        list.add(new Point(8,5));
        list.add(new Point(3,4));
        list.add(new Point(9,8));
        System.out.println(list);
        /*
            compare:比较
            comparable:可比较
            sort方法在排序List集合时，要求集合元素必须实现了Comparable接口

            这里该方式会对我们的代码造成侵入性:
            当我们使用某一个功能时，其要求我们为其修改更多额外代码，这就是侵入性。
            它不利于后期程序的维护。尽量避免。
         */
//        Collections.sort(list);
        //Type 类型
//        Comparator<Point> c = new Comparator<Point>() {
//            /**
//                重写compare方法的目的是定义o1与o2的大小关系。
//                返回值的定义:
//                当返回值>0时，表达的是o1>02
//                当返回值<0时，表达的是o1<o2
//                当返回值=0时，表达的是o1=o2
//             */
//            public int compare(Point o1, Point o2) {
//                //点到原点的距离长的大
//                int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
//                int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
////                return len1-len2;
//                return len2-len1;//降序 两个数反过来相减就是降序
//            }
//        };
//        /*
//            java有23种设计模式
//            回调模式
//            当我们定义一个类，并定义了对应的一些方法，但是这些方法我们并不会主动调用
//            而是传递给了一个功能，该功能内部实现过程中会反过来调用我们定义的这些方法，
//            这个过程称为:回调
//         */
//        Collections.sort(list,c);


        //没有侵入性写法
//        Collections.sort(list,new Comparator<Point>() {
//            public int compare(Point o1, Point o2) {
//                int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
//                int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
//                return len1-len2;
//            }
//        });


        Collections.sort(list,(o1,o2)->
                o1.getX()*o1.getX()+o1.getY()*o1.getY() -
                o2.getX()*o2.getX()-o2.getY()*o2.getY()
        );

        System.out.println(list);


    }
}
