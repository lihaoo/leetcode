package jianzhi.day9;

import java.util.ArrayList;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }

        int a = left - right;
        return (a == 0 || a == 1 || a == -1) ? (Math.max(left, right) + 1) : -1;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        int thisLevelCount = 1;
        int thisLevelHasDeleteCount = 0;
        int deep = 0;

        while (arrayList.size() > 0) {
            TreeNode treeNode = arrayList.remove(0);
            thisLevelHasDeleteCount++;
            if (treeNode.left != null) {
                arrayList.add(treeNode.left);
            }
            if (treeNode.right != null) {
                arrayList.add(treeNode.right);
            }
            if (thisLevelCount == thisLevelHasDeleteCount) {
                thisLevelHasDeleteCount = 0;
                thisLevelCount = arrayList.size();
                deep++;
            }
        }
        return deep;
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
