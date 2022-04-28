package file;

import java.io.File;
import java.io.IOException;

/**
 *  create : 创造，制造
 *  exists : 存在
 *
 *  File提供了创建一个文件的方法:createNewFile()
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前目录下新建一个文件:test.txt
        File file = new File("./test.txt");
        boolean exists = file.exists();//判断当前File表示的文件或目录是否真实存在
        if(exists) {
            System.out.println("该文件已经存在了!");
        }else{
            file.createNewFile();//创建它
        }
    }
}
