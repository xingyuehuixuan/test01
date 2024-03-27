package algorithm;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head = new Node(666,null);

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node{
        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value){
        insert(0, value);
    }

    public void loop(Consumer<Integer> consumer){
        Node p = head.next;
        while (p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    private Node findLast(){
        Node p;
        for (p = head; p.next != null; p = p.next){}
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findNode(int index){
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++){
            if (i == index){
                return p;
            }
        }
        return null;
    }

    public int get(int index){
        Node node = findNode(index);
        if (node == null){
            throw new IllegalArgumentException("没这个索引呆瓜");
        }
        return node.value;
    }

    public void insert(int index, int value){
        Node prev = findNode(index - 1);
        if (prev == null){
            throw new IllegalArgumentException("没这个索引呆瓜");
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeFirst(){
        remove(0);
    }

    public void remove(int index){
        Node prev = findNode(index - 1);
        if (prev == null || prev.next == null){
            throw new NullPointerException("你到底在删些什么东西？");
        }
        prev.next = prev.next.next;
    }
}
