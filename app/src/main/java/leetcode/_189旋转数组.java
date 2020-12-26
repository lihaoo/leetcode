package leetcode;

public class _189旋转数组 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        k = k % nums.length;

        if (k <= 0) {
            return;
        }

        int count = 0;

        for (int i = 0; count < nums.length; i++) {
            int temp = nums[i];
            int index = k + i;
            do {
                index = (k + index) % nums.length;
                int x = nums[index];
                nums[index] = temp;
                temp = x;

                count++;
            }
            while (i != index);
        }
    }
}
