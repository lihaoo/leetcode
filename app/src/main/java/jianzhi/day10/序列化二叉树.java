package jianzhi.day10;

import java.util.Stack;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class 序列化二叉树 {
    String Serialize(TreeNode root) {
        return getValueByPreorder(root);
    }

    TreeNode Deserialize(String str) {
        char[] chars = str.toCharArray();

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder value = new StringBuilder();
        TreeNode root = null;
        TreeNode lastTreeNode = null;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '!' && chars[i] != '#') {
                value.append(chars[i]);
            } else {
                TreeNode treeNode = getTreeNode(value.toString());
                value = new StringBuilder();
                if (root == null) {
                    root = treeNode;
                    lastTreeNode = root;
                }

                if (lastTreeNode == null && !stack.isEmpty()) {
                    lastTreeNode = stack.pop();
                    lastTreeNode.right = treeNode;
                    lastTreeNode = treeNode;
                } else {
                    stack.add(lastTreeNode);
                    lastTreeNode.left = treeNode;
                    lastTreeNode = lastTreeNode.left;
                }
            }
        }
        return root;
    }

    private TreeNode getTreeNode(String s) {
        if (s == null) {
            return null;
        } else {
            TreeNode treeNode = new TreeNode(Integer.parseInt(s));
            return treeNode;
        }
    }

    private String getValueByPreorder(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            return stringBuilder.toString();
        }
        TreeNode treeNode = root;
        Stack<TreeNode> treeNodes = new Stack<>();
        while (treeNode != null || !treeNodes.isEmpty()) {
            while (treeNode != null) {
                treeNodes.add(treeNode);
                stringBuilder.append(treeNode.val + "!");
                treeNode = treeNode.left;
            }
            stringBuilder.append("#");
            if (!treeNodes.isEmpty()) {
                treeNode = treeNodes.pop();
                treeNode = treeNode.right;
            }
        }

        return stringBuilder.toString();
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