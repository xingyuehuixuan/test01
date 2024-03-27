package Queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2<E> implements BlockingQueue<E> {
    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger();
    private ReentrantLock headLock = new ReentrantLock();
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition headWait = headLock.newCondition();
    private Condition tailWait = tailLock.newCondition();

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int c;
        tailLock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWait.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            c = size.getAndIncrement();
            if (c + 1 < array.length) {
                tailWait.signal();
            }
        } finally {
            tailLock.unlock();
        }
        if (c == 0) {
            headLock.lock();
            try {
                headWait.signal();
            } finally {
                headLock.unlock();
            }
        }

    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int c;
        headLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWait.await();
            }
            e = array[head];
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            c = size.getAndDecrement();
            if (c > 1) {
                headWait.signal();
            }
        } finally {
            headLock.unlock();
        }
        if (c == array.length) {
            tailLock.lock();
            try {
                tailWait.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return e;
    }
}
