package IOdemo;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("myAPI\\a.txt",true);
        fw.write("汤机灵也一样");
        char[] chars = {'3','4'};
        fw.write(chars);
        fw.close();
    }
}
