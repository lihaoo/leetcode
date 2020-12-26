package leetcode;

public class _238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = temp * nums[i];
            temp *= nums[i];
        }

        return answer;
    }
}
