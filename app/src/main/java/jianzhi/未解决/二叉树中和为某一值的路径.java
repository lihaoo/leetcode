package jianzhi.未解决;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */

public class 二叉树中和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null) {
            return arrayLists;
        }

        TreeNode treeNode = root;
        return FindPath(treeNode, target);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                if () {

                }
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public int getStackSum(Stack<TreeNode> stack) {
        Stack<TreeNode> stack2 = stack.clone();
        int a = 0;
        while (!stack.isEmpty()) {

        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target, ArrayList<Integer> integers) {
        if (root != null && root.right == null && root.left == null && root.val == target) {
            integers.add(root.val);
            arrayLists.add(integers);
            return arrayLists;
        }

        if (root == null) {
            return arrayLists;
        }

        integers.add(root.val);

        if (root.left != null) {
            ArrayList<Integer> left = new ArrayList<>(integers);
            FindPath(root.left, target - root.val, left);
        }

        if (root.right != null) {
            ArrayList<Integer> right = new ArrayList<>(integers);
            FindPath(root.right, target - root.val, right);
        }

        return arrayLists;
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
