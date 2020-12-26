package leetcode;

public class _98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode lower, TreeNode upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && root.val <= lower.val) {
            return false;
        }

        if (upper != null && root.val >= upper.val) {
            return false;
        }

        return helper(root.left, lower, root) && helper(root.right, root, upper);
    }
}
