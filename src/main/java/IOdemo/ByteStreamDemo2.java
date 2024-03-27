package IOdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("myAPI\\a.txt");
        int b;
        while ((b = fileInputStream.read()) != -1){
            System.out.print((char) b);
        }
        fileInputStream.close();
    }
}
