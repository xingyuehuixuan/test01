package waitandnotify;

public class ThreadDemo {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        consumer.setName("消费者");
        producer.setName("生产者");
        consumer.start();
        producer.start();
    }
}
