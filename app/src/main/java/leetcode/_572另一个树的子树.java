package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _572另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null) {
            return false;
        }

        if (s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null) {
            return false;
        }

        ArrayList<Integer> sPre = pre(s);
        ArrayList<Integer> tPre = pre(t);

        boolean pre = false;
        for (int i = 0; i <= sPre.size() - tPre.size(); i++) {
            for (int j = 0; j < tPre.size(); j++) {
                if (sPre.get(i + j) != tPre.get(j)) {
                    break;
                }
                if (j == tPre.size() - 1) {
                    pre = true;
                }
            }
            if(pre){
                break;
            }
        }

        if (!pre) {
            return false;
        }

        ArrayList<Integer> sMid = mid(s);
        ArrayList<Integer> tMid = mid(t);

        boolean mid = false;
        for (int i = 0; i <= sMid.size() - tMid.size(); i++) {
            for (int j = 0; j < tMid.size(); j++) {
                if (sMid.get(i + j) != tMid.get(j)) {
                    break;
                }
                if (j == tMid.size() - 1) {
                    mid = true;
                }
            }
            if(mid){
                break;
            }
        }
        return mid;
    }

    public ArrayList pre(TreeNode s) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while (!stack.empty() || s != null) {
            if (s != null) {
                stack.add(s);
                integers.add(s.val);

                s = s.left;
            } else {
                s = stack.pop().right;
            }
        }

        return integers;
    }

    public ArrayList mid(TreeNode s) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while (!stack.empty() || s != null) {
            if (s != null) {
                stack.add(s);
                s = s.left;
            } else {
                s = stack.pop();
                integers.add(s.val);
                s = s.right;
            }
        }

        return integers;
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
