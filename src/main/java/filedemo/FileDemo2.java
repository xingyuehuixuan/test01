package filedemo;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo2 {
    public static void main(String[] args) {
//        D:\html-demo
//        File f1 = new File("D:\\html-demo");
////        String[] list = f1.list();
////        for (String s : list) {
////            System.out.println(s);
////        }
//        String[] list = f1.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                File src = new File(dir, name);
//
//                return src.isFile() && name.endsWith(".html");
//            }
//        });
//        for (String s : list) {
//            System.out.println(s);
//        }

        File f2 = new File("D:\\html-demo");
//        File[] files = f2.listFiles();
//        for (File file : files) {
//            System.out.println(file);
//        }

//        File[] files1 = f2.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                File src = new File(dir,name);
//                return src.isFile() && name.endsWith(".html");
//            }
//        });
//        for (File file : files1) {
//            System.out.println(file);
//        }

        File[] files = f2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.toString().endsWith(".html");
            }
        });
        for (File file : files) {
            System.out.println(file);
        }


    }


}
