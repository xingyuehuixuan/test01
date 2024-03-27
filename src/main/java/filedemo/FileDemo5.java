package filedemo;

import java.io.File;

public class FileDemo5 {
    public static void main(String[] args) {

        findAVI();
    }

    public static void findAVI(){
        File[] arr = File.listRoots();
        for (File file : arr) {
            findAVI(file);
        }
    }
    public static void findAVI(File file){
        File[] files = file.listFiles();
        if(files!=null){
            for (File file1 : files) {
                if(file1.isFile()){
                    if(file1.getName().endsWith(".avi")){
                        System.out.println(file1);
                    }
                }else {
                    findAVI(file1);
                }

            }
        }

    }


}
