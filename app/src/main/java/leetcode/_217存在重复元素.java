package leetcode;

import java.util.HashSet;

public class _217存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        HashSet hashSet = new HashSet();
        boolean x = false;
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                x = true;
                break;
            }
            hashSet.add(nums[i]);
        }

        return x;
    }
}
