package leetcode;

public class _437路径总和III {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.val == sum) {
            return 1;
        }

        return pathSum(root.left, sum) + pathSum(root.right, sum)
                + pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val);
    }
}
