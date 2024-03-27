package filedemo;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("myAPI\\aaa");
        f1.mkdirs();
        File src = new File(f1,".txt");
        boolean b = src.createNewFile();
        if (b){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }

    }
}
