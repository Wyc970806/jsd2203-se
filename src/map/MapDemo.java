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
        value = map.get("体育");
        /*
            如果Map的value是包装类类型，当我们获取value值时，也一定使用包装类
            类型的变量去接收返回值。避免使用基本类型。因为这可能导致触发自动拆箱
            特性。如果返回值为null导致自动拆箱出现空指针异常
            int value1 = map.get("体育");
                        VVV  自动拆箱
            int value1 = map.get("体育").intValue();
                            null.intValue(); 空指针!
         */

        System.out.println(value);//null

        /*
            int size()
            返回当前Map的元素个数，每一组键值对算是一个元素
         */
        int size = map.size();
        System.out.println("size:"+size);

//        map.clear();//清空Map

        /*
            boolean containsKey(Object key)
            判断当前Map是否包含给定的key

            boolean containsValue(Value value)
            判断当前Map是否包含给定的value
         */
//        boolean ck = map.containsKey("化学");
        boolean ck = map.containsKey("体育");
        System.out.println("包含key:"+ck);

        boolean cv = map.containsValue(98);
        System.out.println("包含value:"+cv);

        System.out.println(map);
        /*
            V remove(Object key)
            从Map中删除给定的key所对应的键值对。返回值为这个key对应的value
            如果给定的key在Map中不存在，则没有任何效果。返回值也为null。
         */
        value = map.remove("数学");
        System.out.println(value);
        System.out.println(map);



    }
}
