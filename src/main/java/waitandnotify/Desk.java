package waitandnotify;

public class Desk extends Thread{
    public static int foodFlag = 0;

    public static int count = 10;
    public static Object lock = new Object();
}
