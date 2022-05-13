package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的遍历
 * Map提供了三种遍历方式:
 * 1:遍历所有的key
 * 2:遍历每一组键值对
 * 3:遍历所有的value(相对不常用)
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",99);
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);

        /*
            遍历所有的key
            Set keySet()
            将当前Map中所有的key以一个Set集合形式返回。
            遍历该集合等于遍历了所有的key
         */
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            System.out.println("key:"+key);
        }

        /*
            遍历每一组键值对
            Set entrySet()
            将Map中每一组键值对以一个Entry实例表示，并将所有的Entry实例存入Set
            集合后将其返回
            Entry是Map的内部接口，每一个Entry实例应当表示Map中的一组键值对。
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry: entrySet){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }
    }
}
