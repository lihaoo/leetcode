package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        int i = 0;
        TreeNode treeNode = null;
        while (!treeNodes.isEmpty() || root != null) {
            if (root != null) {
                treeNodes.add(root);
                root = root.left;
            } else {
                root = treeNodes.remove(treeNodes.size() - 1);
                root = root.right;

                if (root.val == p.val || root.val == q.val) {
                    i++;

                    if (i == 2) {
                        return treeNode;
                    }
                }

                treeNode = root;
            }
        }

        return treeNode;
    }

}
