package jianzhi.day8;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        if (pRoot == null) {
            return arrayLists;
        }

        ArrayList<Integer> integers = new ArrayList<>();

        Stack<TreeNode> leftStart = new Stack<>();
        Stack<TreeNode> rightStart = new Stack<>();

        leftStart.add(pRoot);

        boolean isLeftStart = true;

        while (!leftStart.empty() || !rightStart.empty()) {
            if (isLeftStart) {
                TreeNode treeNode = leftStart.pop();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    rightStart.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    rightStart.add(treeNode.right);
                }
                if (leftStart.isEmpty()) {
                    isLeftStart = false;
                    arrayLists.add(integers);
                    integers = new ArrayList<>();
                }
            } else {
                TreeNode treeNode = rightStart.pop();
                integers.add(treeNode.val);
                if (treeNode.right != null) {
                    leftStart.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    leftStart.add(treeNode.left);
                }
                if (rightStart.isEmpty()) {
                    isLeftStart = true;
                    arrayLists.add(integers);
                    integers = new ArrayList<>();
                }
            }
        }

        return arrayLists;
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
