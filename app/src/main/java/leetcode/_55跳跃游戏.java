package leetcode;

public class _55跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        return goToEnd(nums, 0);
    }

    private boolean goToEnd(int[] nums, int index) {
        if (nums.length <= index + 1) {
            return true;
        }
        boolean a;
        while (nums[index] > 0) {
            a = goToEnd(nums, index + nums[index]);
            nums[index]--;
            if (a) {
                return true;
            }
        }

        return false;
    }
}
