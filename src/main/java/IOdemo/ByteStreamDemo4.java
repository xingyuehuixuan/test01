package IOdemo;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("myAPI\\a.txt");
        byte[] bytes = new byte[2];
        int len = fis.read(bytes);
        System.out.println(len);
        String str = new String(bytes,0,len);
        System.out.println(str);

        int len1 = fis.read(bytes);
        System.out.println(len1);
        String str1 = new String(bytes,0,len1);
        System.out.println(str1);
    }
}
