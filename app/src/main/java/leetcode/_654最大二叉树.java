package leetcode;

public class _654最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int i = start;
        int max = -1;
        for (int j = start; j <= end; j++) {
            if (max < nums[j]) {
                i = j;
                max = nums[j];
            }
        }

        TreeNode treeNode = new TreeNode(nums[i]);
        treeNode.left = constructMaximumBinaryTree(nums, start, i - 1);
        treeNode.right = constructMaximumBinaryTree(nums, i + 1, end);
        return treeNode;
    }
}
