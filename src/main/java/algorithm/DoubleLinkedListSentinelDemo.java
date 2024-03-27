package algorithm;

import java.util.Iterator;

public class DoubleLinkedListSentinelDemo {
    public static void main(String[] args) {
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();
        doubleLinkedListSentinel.addLast(1);
        doubleLinkedListSentinel.addLast(2);
        doubleLinkedListSentinel.addLast(3);
        doubleLinkedListSentinel.addLast(4);
        Iterator<Integer> it = doubleLinkedListSentinel.iterator();
        while (it.hasNext()){
            Integer value = it.next();
            System.out.println(value);
        }
    }
}
