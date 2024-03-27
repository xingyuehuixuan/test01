package threadtest3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,13,35,2,5647,23,1,1411,1314,9);
        MyCallable mc = new MyCallable(list);
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);
        Thread t1 = new Thread(ft1,"抽奖箱1");
        Thread t2 = new Thread(ft2,"抽奖箱2");
        t1.start();
        t2.start();
        Integer result1 = ft1.get();
        Integer result2 = ft2.get();
        System.out.println(result1);
        System.out.println(result2);

    }
}
