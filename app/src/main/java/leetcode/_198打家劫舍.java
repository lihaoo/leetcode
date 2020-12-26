package leetcode;

public class _198打家劫舍 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return get(nums);
    }

    private int get(int[] nums) {
        int result = 0;

        int x_i_2 = nums[0];
        int x_i_1 = Math.max(x_i_2, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            result = Math.max(x_i_1, nums[i] + x_i_2);
            int temp = x_i_1;
            x_i_1 = result;
            x_i_2 = temp;

        }

        return result;
    }
}
