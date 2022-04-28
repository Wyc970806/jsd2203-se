package file;

import java.io.File;
import java.io.IOException;

/**
 * parent:父母  java中我们可以理解为是父目录
 *
 * File常见的构造器二:
 * File(File parent,String pathname)
 * 参数1:当前File表示的文件或目录所处的父目录
 * 参数2:当前File表示的文件或目录的地址
 */
public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        //在当前目录下新建一个目录:test
        File dir = new File("./test");
        if(!dir.exists()){
            dir.mkdirs();//创建该目录
        }
        //在test目录下新建一个文件:demo.txt
//        File file = new File("./test/demo.txt");
        File file = new File(dir,"demo.txt");
        if(!file.exists()){
            file.createNewFile();
        }

    }
}
