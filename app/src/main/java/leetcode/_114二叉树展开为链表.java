package leetcode;

public class _114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        getTreeNode(root);
    }

    public TreeNode getTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode left = getTreeNode(treeNode.left);
        TreeNode right = getTreeNode(treeNode.right);

        treeNode.right = left;
        treeNode.left = null;

        TreeNode treeNode1 = treeNode;
        while (treeNode1.right != null) {
            treeNode1 = treeNode1.right;
        }
        treeNode1.right = right;
        return treeNode;
    }
}
