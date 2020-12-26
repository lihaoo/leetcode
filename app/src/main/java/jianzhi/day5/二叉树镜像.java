package jianzhi.day5;

public class 二叉树镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode treeNode = root;
        while (treeNode.left == null && treeNode.right == null) {
            treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;

            treeNode = treeNode.left;
        }


    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
