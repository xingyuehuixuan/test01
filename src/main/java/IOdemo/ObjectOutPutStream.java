package IOdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutPutStream {
    public static void main(String[] args) throws IOException {
        Student student = new Student("zhangsan",23);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myAPI\\e.txt"));
        oos.writeObject(student);
        oos.close();
    }
}
