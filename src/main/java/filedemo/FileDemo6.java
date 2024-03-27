package filedemo;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {

        File file = new File("D:\\html-demo");
        long len = getLen(file);
        System.out.println(len);

    }

    public static long getLen(File file){
        long len = 0;
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()){
                len = len + file1.length();
            }else {
                len = len + getLen(file1);
            }
        }
        return len;
    }

}
