package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合可以获取子集:
 *
 * List subList(int start,int end)
 * 获取指定范围的子集
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(3,8);
        System.out.println(subList);

    }
}







