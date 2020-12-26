package leetcode;

public class _105从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1 || inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode treeNode = new TreeNode(preorder[0]);

        int x = getIndex(preorder[0], inorder);
        int[] leftPreorder = new int[x];
        int[] leftInorder = new int[x];

        int[] rightPreorder = new int[preorder.length - x - 1];
        int[] rightInorder = new int[preorder.length - x - 1];

        for (int i = 0; i < x; i++) {
            leftPreorder[i] = preorder[i + 1];
            leftInorder[i] = inorder[i];
        }
        treeNode.left = buildTree(leftPreorder, leftInorder);

        for (int i = 0; i < preorder.length - x - 1; i++) {
            rightPreorder[i] = preorder[x + i + 1];
            rightInorder[i] = inorder[x + i + 1];
        }
        treeNode.right = buildTree(rightPreorder, rightInorder);

        return treeNode;
    }

    private int getIndex(int x, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (x == inorder[i]) {
                return i;
            }
        }

        return -1;
    }
}
