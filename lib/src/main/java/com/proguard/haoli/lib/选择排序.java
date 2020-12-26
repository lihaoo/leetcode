package com.proguard.haoli.lib;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Created by hao.li on 2019/10/28.
 */

public class 选择排序 {

    public static void main(String arg[]) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(getLeft(treeNode1));
        System.out.println(getRight(treeNode1));

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }

        return getLeft(pRoot).equals(getRight(pRoot));
    }

    private static String getLeft(TreeNode treeNode) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);
                stringBuilder.append(treeNode.val);
                treeNode = treeNode.left;
            }
            stringBuilder.append("#");
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return stringBuilder.toString();
    }

    private static String getRight(TreeNode treeNode) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null && !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);
                stringBuilder.append(treeNode.val);
                treeNode = treeNode.right;
            }
            stringBuilder.append("#");
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.left;
            }
        }
        return stringBuilder.toString();
    }

    private static TreeNode Deserialize(String str) {
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

    private static TreeNode getTreeNode(String s) {
        if (s == null || s == "" || s.length() < 1) {
            return null;
        } else {
            TreeNode treeNode = new TreeNode(Integer.parseInt(s));
            return treeNode;
        }
    }

    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        int count = 0;

        TreeNode treeNode = pRoot;
        Stack<TreeNode> treeNodes = new Stack<>();

        while (!treeNodes.isEmpty() || treeNode != null) {
            while (treeNode != null) {
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

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<TreeNode> integers = new ArrayList<>();
        integers.add(root);

        ArrayList<Integer> result = new ArrayList<>();

        while (integers.size() > 0) {
            TreeNode treeNode = integers.remove(0);

            integers.add(treeNode.left);
            integers.add(treeNode.right);

            result.add(treeNode.val);
        }

        return result;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return integers;
        }

        int rows = matrix.length;
        int lows = matrix[0].length;

        int startX = 0, startY = 0;
        int endX = lows - 1, endY = rows - 1;

        while (startX <= endX && startY <= endY) {

            for (int i = startX; i <= endX; i++) {
                integers.add(matrix[startY][i]);
            }

            startY++;


            for (int i = startY; i <= endY; i++) {
                integers.add(matrix[i][endX]);
            }

            endX--;

            if (endX < startX) {
                break;
            }

            for (int i = endX; i >= startX; i--) {
                integers.add(matrix[endY][i]);
            }

            endY--;
            if (startY > endY) {
                break;
            }
            for (int i = endY; i >= startY; i--) {
                integers.add(matrix[i][startX]);
            }
            startX++;

        }

        if (startX == endX && startY == endY) {
            integers.add(matrix[startY][startX]);
        }

        return integers;

    }
}
