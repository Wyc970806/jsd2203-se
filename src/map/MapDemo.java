package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Map 查找表
 * java.util.Map接口，规定了Map的相关功能。
 * Map体现的结构是一个多行两列的表格，其中左列称为key，右列称为value
 * Map总是根据key获取value.
 *
 * 常用的实现类:
 * java.util.HashMap散列表，当今查询速度最快的数据结构。
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //LinkedHashMap是有序的散列表，遍历顺序与put顺序一致。
//        Map<String,Integer> map = new LinkedHashMap<>();

        /*
            V put(K k ,V v)
            将一组键值对存入到Map中。

            Map要求key是不允许重复的！！！！！！！！！！！！key的equals不能为true
            因此，使用重复的key存入新的value时，那么就是替换value操作。此时put方法
            返回值为被替换的value。否则返回值为null。
         */
        Integer value = map.put("语文",99);//返回值为null，没有value被替换
        System.out.println(value);//null
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);
        value = map.put("英语",60);//替换英语原来的值97
        System.out.println(value);//97
        System.out.println(map);

        /*
            V get(Object key)
            根据给定的key获取对应的value。
            如果给定的key不存在则返回值为null。
         */
        value = map.get("数学");
        System.out.println(value);



    }
}
