package threadsafe2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable,"窗口1");
        Thread t2 = new Thread(myRunnable,"窗口2");
        Thread t3 = new Thread(myRunnable,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
