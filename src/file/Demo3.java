package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取当前目录下所有的文件（当前目录下的子目录不要）.
 */
public class Demo3 {
    public static void main(String[] args) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();//如果file表示的是一个文件则返回true
            }
        };
        File dir = new File(".");
        if(dir.isDirectory()){
            File[] subs = dir.listFiles(filter);
            System.out.println(subs.length);
        }

    }
}
