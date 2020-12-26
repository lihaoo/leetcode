package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _116填充每个节点的下一个右侧节点指针 {
    List<Node> nodes = new ArrayList<>();

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            for (int i = 0; i < nodes.size(); i++) {
                if (i == nodes.size() - 1) {
                    nodes.get(i).next = null;
                } else {
                    nodes.get(i).next = nodes.get(i + 1);
                }
            }

            int count = nodes.size();
            while (count-- > 0) {
                Node n = nodes.remove(0);
                if (n.left == null) {
                    continue;
                }
                nodes.add(n.left);
                nodes.add(n.right);
            }
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
