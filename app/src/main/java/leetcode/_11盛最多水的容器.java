package leetcode;

public class _11盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int count = 0;
        while (left < right) {
            count = Math.max(count, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
