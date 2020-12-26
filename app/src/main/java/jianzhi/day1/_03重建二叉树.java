package jianzhi.day1;

/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 二叉树的前中后序遍历，只有有中序遍历及前后任一顺序遍历时才能重建二叉树
 * <p>
 * 记得运用递归的方法写前中后序遍历
 */

public class _03重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = new TreeNode(pre[0]);

        int[] inLeft = getInLeft(pre[0], in);
        if (inLeft != null) {
            int[] preLeft = getLeftPre(inLeft, pre);
            treeNode.left = reConstructBinaryTree(preLeft, inLeft);
        }

        int[] inRight = getInRight(pre[0], in);
        if (inRight != null) {
            int[] preRight = getRightPre(inRight, pre);
            treeNode.right = reConstructBinaryTree(preRight, inRight);
        }

        return treeNode;
    }

    private int[] getLeftPre(int[] in, int[] pre) {
        if (in == null || in.length == 0 || pre == null || pre.length == 0) {
            return null;
        }

        int[] newPre = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            newPre[i] = pre[i + 1];
        }

        return newPre;
    }

    private int[] getRightPre(int[] in, int[] pre) {
        if (in == null || in.length == 0 || pre == null || pre.length == 0) {
            return null;
        }

        int[] newPre = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            newPre[newPre.length - i - 1] = pre[pre.length - 1 - i];
        }

        return newPre;
    }

    /**
     * 获取数组target值target以左的部分
     *
     * @param target
     * @param array
     * @return
     */
    private int[] getInLeft(int target, int[] array) {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                length = i;
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        int left[] = new int[length];

        for (int i = 0; i < length; i++) {
            left[i] = array[i];
        }

        return left;
    }

    /**
     * 获取数组target值target以右的部分
     *
     * @param target
     * @param array
     * @return
     */
    private int[] getInRight(int target, int[] array) {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                length = array.length - (i + 1);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        int right[] = new int[length];

        for (int i = 0; i < length; i++) {
            right[length - 1 - i] = array[array.length - 1 - i];
        }

        return right;
    }


    public class TreeNode {
        TreeNode left;
        TreeNode right;
        public int val;

        TreeNode(int x) {
            val = x;
        }
    }
}

