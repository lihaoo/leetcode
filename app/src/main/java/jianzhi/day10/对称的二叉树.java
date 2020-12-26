package jianzhi.day10;

import java.util.Stack;

public class 对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }

        return getLeft(pRoot).equals(getRight(pRoot));
    }

    private String getLeft(TreeNode treeNode) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);
                stringBuilder.append(treeNode.val);
                treeNode = treeNode.left;
            }
            stringBuilder.append("#");
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return stringBuilder.toString();
    }

    private String getRight(TreeNode treeNode) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);
                stringBuilder.append(treeNode.val);
                treeNode = treeNode.right;
            }
            stringBuilder.append("#");
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.left;
            }
        }
        return stringBuilder.toString();
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
