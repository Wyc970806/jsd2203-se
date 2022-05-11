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

        //将子集每个元素扩大10倍
        for(int i=0;i<subList.size();i++){
            int num = subList.get(i);
            num = num * 10;
            subList.set(i,num);
        }
        System.out.println(subList);//[30,40,50,60,70]
        /*
            对子集的任何操作就是对原集合对应元素的操作
         */
        System.out.println(list);//[0, 1, 2, 30, 40, 50, 60, 70, 8, 9]

        //将list集合中2-8这部分元素删除
        list.subList(2,9).clear();
        System.out.println(list);

    }
}







