package jianzhi.day7;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class 包含min函数的栈 {
    Stack<Integer> integers = new Stack<>();
    Stack<Integer> min = new Stack<>();
    int minNum = 0x7fffffff;

    public void push(int node) {
        integers.push(node);
        minNum = Math.min(node, minNum);
        min.push(minNum);
    }

    public void pop() {
        integers.pop();
        min.pop();
    }

    public int top() {
        return min.peek();
    }

    public int min() {
        return min.peek();
    }
}
