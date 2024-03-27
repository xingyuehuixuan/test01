package leetcode;

import Stack.ArrayStack;

public class Leetcode232 {
    ArrayStack<Integer> s1 = new ArrayStack<Integer>(100);
    ArrayStack<Integer> s2 = new ArrayStack<Integer>(100);

    public void push(int x){
        s2.push(x);
    }
    public int pop(){
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s2.pop();
    }

    public int peek(){
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }

}
