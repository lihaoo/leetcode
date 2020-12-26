package jianzhi.day8;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        ArrayList<TreeNode> integers1 = new ArrayList<>();
        int thisLevelCount = 0;

        integers1.add(pRoot);

        int nextLevelCount = 1;
        ArrayList<Integer> integers2 = new ArrayList<>();

        while (integers1.size() > 0) {
            thisLevelCount++;
            TreeNode treeNode = integers1.remove(0);
            integers2.add(treeNode.val);

            if (treeNode.left != null) {
                integers1.add(treeNode.left);
            }

            if (treeNode.right != null) {
                integers1.add(treeNode.right);
            }

            if (thisLevelCount == nextLevelCount) {
                thisLevelCount = 0;
                arrayLists.add(integers2);
                integers2 = new ArrayList<>();
                nextLevelCount = integers1.size();
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
