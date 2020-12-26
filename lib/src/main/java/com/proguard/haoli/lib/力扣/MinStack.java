package com.proguard.haoli.lib.力扣;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);

        minStack.top();
        minStack.pop();

        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();

        minStack.push(2147483647);
        minStack.top();

        System.out.println("=====" + minStack.getMin());

        minStack.push(-2147483648);

    }

    private Stack<Integer> integers;
    private Stack<Integer> minStack;

    public MinStack() {
        integers = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        integers.push(x);

        if (minStack.empty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        if (integers.empty()) {
            return;
        }

        integers.pop();
        minStack.pop();
    }

    public int top() {
        if (integers.empty()) {
            return 0;
        }
        return integers.peek();
    }

    public int getMin() {
        if (minStack.empty()) {
            return 0;
        }
        return minStack.peek();
    }
}
