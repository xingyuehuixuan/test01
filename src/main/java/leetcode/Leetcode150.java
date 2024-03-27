package leetcode;

import java.util.LinkedList;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }
        return stack.pop();
    }
}
