package file;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();//获取当前系统时间的毫秒值
        System.out.println(start);

        long l = 1651031076964L;
        Date data = new Date(l);//日期
        System.out.println(data);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String line = sdf.format(data);
        System.out.println(line);
    }
}
