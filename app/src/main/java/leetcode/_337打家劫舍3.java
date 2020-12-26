package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _337打家劫舍3 {

    private Map<TreeNode, Integer> treeNodeIntegerMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (treeNodeIntegerMap.containsKey(root)) {
            return treeNodeIntegerMap.get(root);
        }

        int choseCurrent = root.val;
        if (root.left != null) {
            treeNodeIntegerMap.put(root.left.left, rob(root.left.left));
            treeNodeIntegerMap.put(root.left.right, rob(root.left.right));

            choseCurrent += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            treeNodeIntegerMap.put(root.right.left, rob(root.right.left));
            treeNodeIntegerMap.put(root.right.right, rob(root.right.right));

            choseCurrent += rob(root.right.left) + rob(root.right.right);
        }

        treeNodeIntegerMap.put(root, choseCurrent);

        treeNodeIntegerMap.put(root.left, rob(root.left));
        treeNodeIntegerMap.put(root.right, rob(root.right));

        int nochoseCurrent = rob(root.left) + rob(root.right);

        return Math.max(choseCurrent, nochoseCurrent);
    }
}
