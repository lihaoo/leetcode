package leetcode;

import java.util.HashMap;

public class _1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        int a = -1, b = -1;
        for (int i = 0; i < nums.length; i++) {
            if(integerIntegerHashMap.containsValue(target-nums[i])){
                return new int[]{integerIntegerHashMap.get(target-nums[i]),nums[i]};
            }
            integerIntegerHashMap.put(nums[i],i);
        }

        return new int[]{ a, b };
    }
}
