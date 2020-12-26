package leetcode;

import java.util.ArrayList;

public class _3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        int i = 0;
        int max = 0;
        while (i < chars.length) {
            if (!characters.contains(chars[i])) {
                characters.add(chars[i]);
                max = Math.max(max, characters.size());
                i++;
            } else {
                characters.remove(0);
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
