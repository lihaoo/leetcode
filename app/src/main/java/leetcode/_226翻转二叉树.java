package leetcode;

public class _226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode treeNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(treeNode);
        return root;
    }

}
