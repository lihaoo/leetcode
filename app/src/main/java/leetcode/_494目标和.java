package leetcode;

public class _494目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 0 && S == 0) {
            return 2;
        }

        if (nums.length == 1) {
            return Math.abs(S) == nums[0] ? 1 : 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (S > sum || -S > sum) {
            return 0;
        }

        int[][] count = new int[2 * sum + 1][nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                count[nums[0] + sum][i] += 1;
                count[sum - nums[0]][i] += 1;
                continue;
            }

            for (int j = 0; j < 2 * sum + 1; j++) {
                if (count[j][i - 1] != 0) {
                    count[j + nums[i]][i] += count[j][i - 1];
                    count[j - nums[i]][i] += count[j][i - 1];
                }
            }
        }

        return count[S + sum][nums.length - 1];
    }
}
