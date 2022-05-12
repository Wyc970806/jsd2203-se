package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(5,6));
        list.add(new Point(15,12));
        list.add(new Point(7,9));
        list.add(new Point(8,5));
        list.add(new Point(3,4));
        list.add(new Point(9,8));
        System.out.println(list);

    }
}
