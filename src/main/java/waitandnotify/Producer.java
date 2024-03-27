package waitandnotify;

public class Producer extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if (Desk.count == 0){
                    break;
                }else {
                    if (Desk.foodFlag == 1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("厨师做了一碗面条");
                        Desk.foodFlag = 1;
                        Desk.lock.notifyAll();
                    }
                }

            }
        }
    }
}
