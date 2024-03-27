package algorithm;

import java.util.Iterator;

public class DoubleLinkedListSentinel implements Iterable<Integer>{

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoubleLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index){
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++){
            if (i == index){
                return p;
            }
        }
        return null;
    }

    public void insert(int value, int index){
        Node prev = findNode(index - 1);
        Node next = prev.next;
        if (prev == null){
            throw new NullPointerException();
        }
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void findFirst(int value){
        insert(value, 0);
    }

    public void remove(int index){
        Node prev = findNode(index - 1);
        Node removed = prev.next;
        Node next = removed.next;
        if (prev == null || removed == tail){
            throw new NullPointerException();
        }
        prev.next = next;
        next.prev = prev;
    }

    public void removeFirst(){
        remove(0);
    }

    public void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast(){
        Node removed = tail.prev;
        if (removed == head){
            throw new NullPointerException();
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
