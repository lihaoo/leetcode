package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        Set<Character> characters = new HashSet<>();
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;

        while (left <= right && right < s.length()) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right++));
                max = Math.max(max, characters.size());
            } else {
                characters.remove(s.charAt(left++));
            }
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        ArrayList<Character> characters = new ArrayList<>();
        int right = 0, left = 0;
        int max = Integer.MIN_VALUE;
        while (right < s.length()) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                characters.remove(0);
                left++;
            }
        }
        return max;
    }
}
