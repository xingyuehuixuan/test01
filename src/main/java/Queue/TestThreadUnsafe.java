package Queue;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition tailWaits = lock.newCondition();
    public void offer(String e) throws InterruptedException {
       // lock.lock();
        lock.lockInterruptibly();
        try {
            while (isFull()){
                tailWaits.await();
            }
            array[tail] = e;
            tail++;
            if (tail == array.length){
                tail = 0;
            }
            size++;
        }finally {
            lock.unlock();
        }
    }
    public boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        TestThreadUnsafe queue = new TestThreadUnsafe();
        new Thread(()-> {
            try {
                queue.offer("e1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1").start();
        new Thread(()-> {
            try {
                queue.offer("e2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t2").start();
    }
}
