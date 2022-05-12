package homework.day09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 改错题
 * 
 * 程序需求:向一个List集合中添加10个数字1-10，并将它们
 * 遍历出来并输出到控制台。
 *
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		//1:泛型必须是引用类型
		//2:List是一个接口，不能实例化
//		List<int> list = new List<int>();
		List<Integer> list = new ArrayList<>();

		//缺少逻辑，添加10个数字
		for(int i=1;i<=10;i++){
			list.add(i);
		}


//		Iterator it = list.iterator();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int i = it.next();
//			System.out.println(it.next());
			System.out.println(i);
		}
	}
}





