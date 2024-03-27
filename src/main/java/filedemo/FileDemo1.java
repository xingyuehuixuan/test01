package filedemo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo1 {
    public static void main(String[] args) {
        File f1 = new File("D:\\a.txt");
        System.out.println(f1.length());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getPath());
        System.out.println(f1.getName());
//        C:\Windows\Branding\shellbrd
        File f2 = new File("C:\\Windows\\Branding\\shellbrd");
        long time = f2.lastModified();
        System.out.println(time);

        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String simpleTime = simpleDateFormat.format(date);
        System.out.println(simpleTime);

    }
}
