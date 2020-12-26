package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(root);

        List<Integer> integers = new ArrayList<>();

        while (!list1.isEmpty()) {
            integers.clear();
            int length = list1.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = list1.get(0);
                list1.remove(0);
                if (treeNode == null) {
                    continue;
                }
                if (treeNode.left != null) {
                    list1.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list1.add(treeNode.right);
                }
                integers.add(treeNode.val);
            }
            lists.add(integers);
        }

        return lists;
    }
}
