package file;

import java.io.File;

/**
 * 删除一个目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        //将当前目录下的demo目录删除
//        File file = new File("./demo");
        File file = new File("./a");
        if(file.exists()){//如果该目录存在
            /*
                delete()方法在删除目录时，要求目录必须是空的，否则删除失败。
             */
            file.delete();
            System.out.println("目录已删除!");
        }else{
            System.out.println("该目录不存在!");
        }
    }
}
