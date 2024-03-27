package threadtest3;

import threadtest2.MyThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    ArrayList<Integer> list =new ArrayList<>();

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true){
            synchronized (MyThread.class){
                if (list.size() == 0){
                    System.out.println(Thread.currentThread().getName() + boxList);
                    break;
                }else {
                    Collections.shuffle(list);
                    Integer prize = list.remove(0);
                    boxList.add(prize);
                    //System.out.println(getName() + "又产生了一个" + prize + "元的大奖");
                }
            }
            Thread.sleep(10);
        }
        if (boxList.size() == 0){
            return null;
        }else {
            return Collections.max(boxList);
        }
    }
}
