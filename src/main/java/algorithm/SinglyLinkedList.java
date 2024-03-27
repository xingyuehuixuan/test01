package algorithm;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer>{
    private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
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
        head = new Node(value, head);
    }

    public void loop(Consumer<Integer> consumer){
        Node p = head;
        while (p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    private Node findLast(){
        if (head == null){
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next){}
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        if (last == null){
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    private Node findNode(int index){
        int i = 0;
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
        if (index == 0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null){
            throw new IllegalArgumentException("没这个索引呆瓜");
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeFirst(){
        if (head == null){
            throw new NullPointerException("你链表都是空的你删什么删？");
        }
        head = head.next;
    }

    public void remove(int index){
        if (index == 0){
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null || prev.next == null){
            throw new NullPointerException("你到底在删些什么东西？");
        }
        prev.next = prev.next.next;
    }

    public void loop2(Consumer<Integer> before, Consumer<Integer> after){
        recursion(head, before, after);
    }

    private void recursion(Node curr, Consumer<Integer> before, Consumer<Integer> after){
        if (curr == null){
            return;
        }
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }

}
