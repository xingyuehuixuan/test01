package IOdemo;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("myAPI\\a.txt");
        int len;
        char[] chars = new char[2];
        while ((len = fr.read(chars)) != -1){
            String str = new String(chars,0,len);
            System.out.print(str);
        }
        fr.close();
    }
}
