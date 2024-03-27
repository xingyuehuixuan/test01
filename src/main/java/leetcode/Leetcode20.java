package leetcode;

import Stack.ArrayStack;

public class Leetcode20 {
    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            }else {
                if (!stack.isEmpty() && c == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
