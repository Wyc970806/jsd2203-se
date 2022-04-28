package file;

import java.io.File;

/**
 * make : 做
 * directory : 目录
 *
 * 注:mkdir实际上也是linux中的一个命令，作用就是新建一个目录(文件夹)
 *
 * 创建目录
 */
public class MkdirDemo {
    public static void main(String[] args) {
        //在当前目录下新建一个目录:demo
//        File dir = new File("./demo");
        File dir = new File("./a/b/c/d/e/f/demo");
        if(dir.exists()){
            System.out.println("该目录已存在");
        }else{
            /*
                mkdir()方法在创建目录时要求该目录所在的目录必须存在，否则创建失败
                mkdirs()方法则会在创建该目录时将所有不存在的父目录全部创建出来。
                实际开发中推荐使用mkdirs()这个方法。
             */
//            dir.mkdir();//将该目录创建出来
            dir.mkdirs();//将该目录创建出来
            System.out.println("目录已创建");
        }
    }
}
