package leetcode;

public class _617合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode head = new TreeNode(t1.val + t2.val);
        head.left = mergeTrees(t1.left, t2.left);
        head.right = mergeTrees(t1.right, t2.right);
        return head;
    }
}
