package leetcode;

public class _53最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int max = 0;
        int temp = 0;
        for (int num : nums) {
            if (num > 0) {
                temp += num;
            } else {
                if (temp + num > 0) {
                    temp += num;
                } else {
                    temp = 0;
                }
            }

            max = Math.max(max, temp);
        }
        if (max == 0) {
            max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
