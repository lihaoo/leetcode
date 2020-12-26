package leetcode;

import android.util.SparseIntArray;

import java.util.HashMap;
import java.util.Map;

public class _169多数元素 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int temp = 0, max = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue()>max){
                max = integerIntegerEntry.getValue();
                temp = integerIntegerEntry.getKey();
            }
        }

        return temp;
    }


    private static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int j = partition(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int base = arr[start];

        while (start < end) {
            while (start < end && base <= arr[end]) {
                end--;
            }
            arr[start] = arr[end];

            while (start < end && base >= arr[start]) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = base;

        return start;
    }
}
