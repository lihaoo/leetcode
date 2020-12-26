package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _225用队列实现栈 {
    Queue<Integer> a = new ArrayDeque<>();
    Queue<Integer> b = new ArrayDeque<>();

    /**
     * Initialize your data structure here.
     */
    public _225用队列实现栈() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        a.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.add(a.remove());
            }
        }

        return b.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.add(a.remove());
            }
        }

        return b.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
