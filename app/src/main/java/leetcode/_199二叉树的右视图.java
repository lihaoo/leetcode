package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: [1,2,3,null,5,null,4]
 */
public class _199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        List<TreeNode> a = new ArrayList<>();
        a.add(root);
        while (!a.isEmpty()) {
            int size = a.size();
            TreeNode treeNode = null;
            while (size-- > 0) {
                treeNode = a.remove(0);
                if (treeNode != null) {
                    if (treeNode.left != null) {
                        a.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        a.add(treeNode.right);
                    }
                }
            }
            if (treeNode != null) {
                integers.add(treeNode.val);
            }
        }
        return integers;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
