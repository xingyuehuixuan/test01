package IOdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("myAPI\\a.txt");
        FileOutputStream fos = new FileOutputStream("myAPI\\c.txt");
        int len;
        byte[] bytes = new byte[1024*1024*5];
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }
}
