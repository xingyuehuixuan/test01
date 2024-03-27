package algorithm;

import java.util.function.Consumer;

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
//        list.loop(value->System.out.println(value));
//        for (Integer value : list) {
//            System.out.println(value);
//        }
        list.insert(2,4);
//        list.loop(value->System.out.println(value));
        list.loop2(value -> System.out.println("before:" + value), value -> System.out.println("after:" + value));
    }

}
