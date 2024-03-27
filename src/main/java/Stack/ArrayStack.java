package Stack;

import org.w3c.dom.Node;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E>{
    private E[] array;
    private int top = 0;

    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()){
            return false;
        }
        array[top] = value;
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        E value = array[top - 1];
        top--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        E value = array[top - 1];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;
            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                E value = array[p - 1];
                p--;
                return value;
            }
        };
    }
}
