package jianzhi.day8;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
 * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class 二叉搜索树的第k个结点 {

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        int count = 0;

        TreeNode treeNode = pRoot;
        Stack<TreeNode> treeNodes = new Stack<>();

        while (!treeNodes.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                treeNodes.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!treeNodes.isEmpty()) {
                treeNode = treeNodes.pop();
                count++;
                if (count == k) {
                    break;
                }
                treeNode = treeNode.right;
            }
        }

        return treeNode;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
