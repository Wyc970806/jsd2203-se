package file;

import java.io.File;
import java.io.IOException;

/**
 * 在当前目录下创建50个目录，名字分别为demo1-demo50
 * 每个目录下新建文件100个，名字为test1.txt-test100.txt
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        for(int i=1;i<=50;i++){
            File dir = new File("./demo"+i);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //当目录创建完毕后，还要在该目录下创建100个文件
            for(int j=1;j<=100;j++){
                File file = new File(dir,"test"+j+".txt");
                if(!file.exists()){
                    file.createNewFile();
                }
            }
        }
    }
}
