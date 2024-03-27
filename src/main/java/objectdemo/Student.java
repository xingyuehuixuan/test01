package objectdemo;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Cloneable{

    private int age;
    private String name;
    private int[] data;

    public Student() {
    }

    public Student(int age, String name, int[] data) {
        this.age = age;
        this.name = name;
        this.data = data;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Arrays.equals(data, student.data);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        int[] data = this.data;
        int[] newData = new int[data.length];
        System.arraycopy(data,0,newData,0,data.length);
        Student stu = (Student) super.clone();
        stu.data = newData;
        return stu;
       // return super.clone();
    }
}
