package IOdemo;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("myAPI\\a.txt");
        int ch;
        while ((ch = fileReader.read()) != -1){
            System.out.print((char) ch);
        }
        fileReader.close();
    }
}
