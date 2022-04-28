package file;

import java.io.File;

/**
 * File : 文件
 * io:input输入 output输出
 * path : 路径
 *
 * java.io.File
 * File的每一个实例用于表示硬盘上的一个文件或目录(实际上表示的是一个抽象路径)
 * File可以:
 * 1:可以访问其表示的文件或目录的属性信息(文件名，大小，修改时间等等)
 * 2:创建或删除文件及目录
 * 3:访问一个目录(文件夹)中的所有子项
 *
 * File不能访问文件数据!!!!
 */
public class FileDemo {
    public static void main(String[] args) {
        //访问当前项目下的demo.txt文件
        /*
            File常用构造器:
            File(String pathname)
            指定一个路径，使当前File对象表达该位置对应的文件或目录。

            这里路径使用一个字符串，路径有两种写法:
            绝对路径:从操作系统定义的"根"开始，比如windows中硬盘上的根从c盘,d盘等盘符开始
                    绝对路径的有点在于清晰明了，但是缺点就是太绝对，不能更好适应跨平台。
            相对路径:相对路径写法常见的为"./",即:当前目录
                    相对路径有更好的适应性，适合跨平台使用，缺点是不够清晰，具体位置的
                    判断要视当前程序的运行环境而定。
                    比如在IDEA中执行当前程序时，IDEA规定的"./"就是当前项目目录
         */
        //  D:/Robin/jsd2203_se/demo.txt
//        File file = new File("D:/Robin/jsd2203_se/demo.txt");
        File file = new File("./demo.txt");
        /*
            File常见方法:
            1:String getName()
              获取File对象表示的文件或目录的名字
            2:long length()
              获取当前File对象表示的文件或目录占用的硬盘空间，单位为字节

            11:27回来
         */
        String name = file.getName();
        System.out.println(name);
        long len = file.length();
        System.out.println(len);
        boolean cr = file.canRead();//是否可读
        boolean cw = file.canWrite();//是否可写
        System.out.println("是否可读:"+cr);
        System.out.println("是否可写:"+cw);
        boolean ih = file.isHidden();
        System.out.println("是否隐藏:"+ih);//是否隐藏

    }
}






