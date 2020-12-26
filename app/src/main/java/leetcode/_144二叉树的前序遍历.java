package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _144二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();

        TreeNode x = root;
        while (x != null || !q.isEmpty()) {
            if (x != null) {
                integers.add(x.val);
                q.add(x);
                x = x.left;
                continue;
            }
            x = q.remove(q.size()-1);
            x = x.right;
        }

        return integers;
    }
}
