package waitandnotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    ArrayBlockingQueue<String> queue;

    @Override
    public void run() {
        while (true){
            try {
                queue.put("面条");
                System.out.println("厨师放了一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
