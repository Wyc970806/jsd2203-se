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
        map.put("语文",99);
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);



    }
}
