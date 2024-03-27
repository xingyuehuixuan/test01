package mapdemo;

import java.util.TreeMap;

public class TreeDemo2 {

    public static void main(String[] args) {
        TreeMap<Student,String> treeMap = new TreeMap<>();
        Student s1 = new Student("zhangsan",12);
        Student s2 = new Student("lisi",13);
        Student s3 = new Student("wangwu",14);

        treeMap.put(s1,"江苏");
        treeMap.put(s2,"上海");
        treeMap.put(s3,"浙江");

        System.out.println(treeMap);
    }
}
