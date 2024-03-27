package objectdemo;

import com.google.gson.Gson;

public class ObjectDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //toString
        //equals,重写来比较内容
        //clone
        int[] data = {1,2,3};
        Student stu1 = new Student(20,"赵困",data);
        Student stu2 = (Student) stu1.clone();




        //Gson
        Gson gson = new Gson();
        String s = gson.toJson(stu1);
        Student stu3 = gson.fromJson(s, Student.class);
        int[] data1 = stu1.getData();
        data1[0] = 2;
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu3);
    }
}
