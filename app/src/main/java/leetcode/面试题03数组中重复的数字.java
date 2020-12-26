package leetcode;

public class 面试题03数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (nums[a] < 0) {
                return nums[a] * -1;
            } else {
                nums[a] *= -1;
            }
        }
        return 0;
    }
}
