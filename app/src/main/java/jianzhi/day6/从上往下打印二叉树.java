package jianzhi.day6;

import java.util.ArrayList;

public class 从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<TreeNode> integers = new ArrayList<>();
        integers.add(root);

        ArrayList<Integer> result = new ArrayList<>();

        while (integers.size() > 0) {
            TreeNode treeNode = integers.remove(0);

            if (treeNode.left != null) {
                integers.add(treeNode.left);
            }
            if (treeNode.right != null) {
                integers.add(treeNode.right);
            }

            result.add(treeNode.val);
        }

        return result;
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
