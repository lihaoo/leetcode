package leetcode;

public class _213打家劫舍2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int x1 = nums[0];
        int x2 = Math.max(x1, nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = x2;
            x2 = Math.max(x1 + nums[i], temp);
            x1 = temp;
        }

        int x11 = nums[1];
        int x22 = Math.max(x11, nums[2]);

        for (int i = 3; i < nums.length; i++) {
            int temp = x22;
            x22 = Math.max(x11 + nums[i], temp);
            x11 = temp;
        }

        return Math.max(x2, x22);
    }

}
