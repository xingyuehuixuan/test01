package IOdemo;

import java.io.*;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("myAPI\\a.txt");
        FileOutputStream fos = new FileOutputStream("myAPI\\b.txt");
        int b;
        long begin = System.currentTimeMillis();
        while ((b = fis.read()) != -1){
            fos.write(b);
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
