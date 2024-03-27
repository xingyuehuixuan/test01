package threadtest2;

import java.util.ArrayList;
import java.util.Collections;

public class ThreadDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,13,35,2,5647,23,1,1411,1314,9);
        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);
        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");
        t1.start();
        t2.start();
    }
}
