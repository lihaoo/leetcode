package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _448找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return integers;
        }

        for (int a : nums) {
            if (a < 0) {
                nums[-a - 1] = Math.abs(nums[-a - 1]) * -1;
            } else {
                nums[a - 1] = Math.abs(nums[a - 1]) * -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            integers.add(i + 1);
        }

        return integers;
    }
}
