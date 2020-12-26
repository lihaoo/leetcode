package leetcode;

public class _283移动零 {
    public void moveZeroes(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[a] = nums[i];
                a++;
            }
        }

        for (int i = 0; i < nums.length - a; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
}
