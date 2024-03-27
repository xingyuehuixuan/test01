package IOdemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutPutStreamTest {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student("zhangsan",21);
        Student s2 = new Student("lisi",22);
        Student s3 = new Student("wangwu",23);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myAPI\\f.txt"));
        oos.writeObject(list);
        oos.close();
    }


}
