package leetcode;

import java.util.Stack;

public class _20有效的括号 {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                char temp = ' ';
                switch (chars[i]) {
                    case ')':
                        temp = '(';
                        break;
                    case '}':
                        temp = '{';
                        break;
                    case ']':
                        temp = '[';
                        break;
                }

                if (stack.isEmpty() || temp != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}