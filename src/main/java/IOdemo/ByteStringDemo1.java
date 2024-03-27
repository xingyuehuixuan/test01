package IOdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStringDemo1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("myAPI\\a.txt");
        String str = "wohaoshuai";
        byte[] bytes = str.getBytes();
        fileOutputStream.write(bytes);
        String str2 = "\r\n";
        byte[] bytes1 = str2.getBytes();
        fileOutputStream.write(bytes1);
        String str3 = "skngsoi";
        byte[] bytes2 = str3.getBytes();
        fileOutputStream.write(bytes2);
        fileOutputStream.close();

    }
}
