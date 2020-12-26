package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        boolean b = true;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                root = treeNodes.remove(0);
                treeNodes.add(root.left);
                treeNodes.add(root.right);
            }

            if (!isY(treeNodes)) {
                b = false;
                break;
            }
        }
        return b;
    }

    private boolean isY(List<TreeNode> treeNodes) {
        boolean b = true;
        for (int i = 0; i < treeNodes.size() / 2; i++) {
            if (treeNodes.get(i) == null && treeNodes.get(treeNodes.size() - i - 1) == null) {
                continue;
            }

            if (treeNodes.get(i) == null || treeNodes.get(treeNodes.size() - i - 1) == null) {
                b = false;
                break;
            }

            if (treeNodes.get(i).val != treeNodes.get(treeNodes.size() - i - 1).val) {
                b = false;
                break;
            }
        }
        return b;
    }
}
