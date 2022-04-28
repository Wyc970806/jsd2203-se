package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 向文件中写入所有英文字母
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("eng.txt");
        /*
            00000000 00000000 00000000 01100001

            2进制
            01100001
            当成整数看待时，它是97
            而在asc编码中，该二进制对应的是字母'a'
         */
        for(int i=0;i<26;i++) {
            fos.write(97+i);
        }
        fos.close();
    }
}
