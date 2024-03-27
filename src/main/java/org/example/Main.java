package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入性别");
        String sex = sc.next();
        if(name.equals("赵困")){
            System.out.println("这是一个傻逼");
        } else if (name.equals("王海旭")) {
            System.out.println("这是个变态");
        } else if(sex.equals("男")){
            System.out.println("他是个帅哥");
        } else if (sex.equals("女")) {
            System.out.println("她是个美女");
        }
    }
}