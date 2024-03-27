package threadmethod2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("非守护线程");
        MyThread2 t2 = new MyThread2("守护线程");
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
