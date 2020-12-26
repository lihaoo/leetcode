package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _567字符串的排列 {
    Map<Character, Integer> s1Map = new HashMap<>();
    Map<Character, Integer> s2Map = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char temp = s1.charAt(i);
            s1Map.put(temp, get(s1Map, temp) + 1);
        }

        int left = 0, right = s1.length();
        for (int i = 0; i < right; i++) {
            char temp = s2.charAt(i);
            s2Map.put(temp, get(s2Map, temp) + 1);
        }

        while (right <= s2.length()) {
            if (check()) {
                return true;
            }
            char temp = s2.charAt(left);
            s2Map.put(temp, get(s2Map, temp) - 1);
            if (right == s2.length()) {
                break;
            }
            temp = s2.charAt(right);
            s2Map.put(temp, get(s2Map, temp) + 1);

            left++;
            right++;
        }
        return false;
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : s2Map.entrySet()) {
            if (entry.getValue() - get(s1Map, entry.getKey()) != 0) {
                return false;
            }
        }
        return true;
    }

    private int get(Map<Character, Integer> map, char a) {
        if (map.containsKey(a)) {
            return map.get(a);
        } else {
            return 0;
        }
    }
}
