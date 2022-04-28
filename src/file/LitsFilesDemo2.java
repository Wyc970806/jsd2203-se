package file;

import java.io.File;
import java.io.FileFilter;

/**
 * Filter : 过滤器
 * accept : 接受
 *
 *
 * 获取一个目录中满足条件的所有子项
 * 重载的listFiles方法:
 * File[] listFiles(FileFilter filter)
 * 该方法需要传入一个过滤器，过滤器中定义了一个过滤条件，此时listFiles方法会利用该
 * 过滤器将该目录中所有子项经过一遍过滤器，并最终返回符合过滤器要求的所有子项。
 */
public class LitsFilesDemo2 {
    public static void main(String[] args) {
        //获取当前目录下名字中含有字母"s"的所有子项
        File dir = new File(".");
        if(dir.isDirectory()){
            FileFilter filter = new FileFilter() {
                /*
                    该方法的作用就是该过滤器的过滤条件，
                    将参数file对象想象为是一个将要经过该过滤器的元素。
                    方法返回值表达该元素是否满足过滤器要求。
                 */
                public boolean accept(File file) {
                    String name = file.getName();//获取该文件或目录的名字
//                    int index = name.indexOf("s");
//                    return index>=0;
                    //字符串支持boolean contains(String str),用于判断当前字符串是否包含参数指定的内容
                    return name.contains("s");

//                    String regex = ".*s.*";
                }
            };
            //将过滤器插到listFiles方法中，将每个子项都经过一次过滤器并返回符合要求的。
            File[] subs = dir.listFiles(filter);
            System.out.println(subs.length);
            for(int i=0;i<subs.length;i++){
                File sub = subs[i];
                System.out.println(sub.getName());
            }
        }
    }
}
