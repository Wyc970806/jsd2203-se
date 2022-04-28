package file;

import java.io.File;

/**
 * delete : 删除
 * 删除一个文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        //将当前目录下的文件test.txt删除
        File file = new File("./test.txt");
        if(file.exists()){//如果该文件存在
            file.delete();
            System.out.println("文件已删除!");
        }else{
            System.out.println("该文件不存在!");
        }

    }
}
