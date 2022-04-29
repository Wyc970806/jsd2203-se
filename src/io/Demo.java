package io;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        char a = '范';
        System.out.println(Integer.toBinaryString((int)a));

        //unicode中'范'的二进制:10000011 00000011

        //11101000 10001100 10000011

        String str = "范";
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(data));

    }
}
