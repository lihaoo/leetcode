package leetcode;

/**
 * 子序列问题 考虑 动态规划 的解法
 * <p>
 * 动态规划：通过以前的值 推出 当前的值
 */
public class _300最长上升子序列 {
    // 普通解法 就是 动态规划
    public int lengthOfLIS(int[] nums) {
        //[10,9,2,5,3,7,101,18]
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] f = new int[nums.length];

        f[0] = 1;
        int maxz = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, f[j]);
                }
            }
            f[i] = max + 1;
            maxz = Math.max(maxz, f[i]);
        }

        return maxz;
    }
}


//    int[] cell = new int[nums.length];
//        cell[0] = 1;
//                for (int i = 0; i < nums.length; i++) {
//        for (int j = 0; j < i; j++) {
//        int maxI = 1;
//        if (nums[i] > nums[j]) {
//        maxI = Math.max(maxI, cell[j] + 1);
//        }
//        cell[i] = maxI;
//        }
//        }
//
//        for (int i = 0; i < cell.length; i++) {
//        cell[0] = Math.max(cell[0], cell[i]);
//        }
//        return cell[0];