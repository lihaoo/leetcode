package jianzhi.day3;

import java.util.ArrayList;
import java.util.Stack;

public class 遍历路径 {
    public static ArrayList<Integer> getPatch(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return path;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);

                if (treeNode.val == target) {
                    return stackToArrayList(stack);
                }

                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }

        return stackToArrayList(stack);
    }

    public static ArrayList<Integer> stackToArrayList(Stack<TreeNode> stack) {
        ArrayList<Integer> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            path.add(0, stack.pop().val);
        }
        return path;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
