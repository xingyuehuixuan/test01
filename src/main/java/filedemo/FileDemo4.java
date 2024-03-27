package filedemo;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {

        File file = new File("D:\\html-demo");
        boolean b = haveAVI(file);
        System.out.println(b);
    }

    public static boolean haveAVI(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile() && file1.getName().endsWith(".avi")){
                return true;
            }
        }
        return false;

    }

}
