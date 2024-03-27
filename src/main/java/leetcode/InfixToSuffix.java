package leetcode;

import java.util.LinkedList;

public class InfixToSuffix {
    private static int priority(char c) {
        switch (c) {
            case '*':
            case '/': {
                return 2;
            }
            case '+':
            case '-': {
                return 1;
            }
            case '(': {
                return 0;
            }
            default: {
                throw new IllegalArgumentException("不合法的运算符");
            }
        }
    }

    public static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/': {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(': {
                    stack.push(c);
                }
                case ')': {
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default: {
                    sb.append(c);
                    break;
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
