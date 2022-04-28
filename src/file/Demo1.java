package file;

import java.io.File;
import java.io.IOException;

/*
    Demo1:要求在当前目录下创建100个文件，名字为test1.txt---test100.txt

    Demo2:要求将当前目录下的test1.txt-test100.txt删除
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        for (int i=1;i<=100;i++){
           File file = new File("./test"+i+".txt");
//           if(!file.exists()){//如果不存在
//               file.createNewFile();
//           }
            if(file.exists()){//如果文件存在
                file.delete();
            }
        }
//        System.out.println("创建完毕!");
        System.out.println("删除完毕!");
    }
}
