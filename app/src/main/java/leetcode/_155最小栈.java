package leetcode;

import java.util.Stack;

public class _155最小栈 {

    class MinStack {
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

}
