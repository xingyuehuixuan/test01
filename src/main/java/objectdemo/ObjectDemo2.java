package objectdemo;

import java.util.Objects;

public class ObjectDemo2 {
    public static void main(String[] args) {
        Student stu1 = new Student(23,"赵困", new int[]{1, 2, 3});
        Student stu2 = new Student(23,"赵困", new int[]{1, 2, 3});

//        boolean result = stu1.equals(stu2);
//        System.out.println(result);
        //Objects.equals
        boolean result = Objects.equals(stu1, stu2);
        System.out.println(result);
        //Objects.isNull
        Student stu3 = new Student();
        boolean aNull = Objects.isNull(stu3);
        System.out.println(aNull);
        //Objects.nonNull
    }
}
