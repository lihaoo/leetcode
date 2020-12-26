package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _76最小覆盖子串 {
    Map<Character, Integer> tHashMap = new HashMap<>();
    Map<Character, Integer> sHashMap = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            int temp = get(tHashMap, t.charAt(i));
            tHashMap.put(t.charAt(i), ++temp);
        }

        int left = 0, right = 0, len = Integer.MAX_VALUE;
        int minLeft = 0;
        boolean b = false;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            sHashMap.put(rightChar, get(sHashMap, rightChar) + 1);
            right++;

            while (check()) {
                char leftChar = s.charAt(left);
                sHashMap.put(leftChar, get(sHashMap, leftChar) - 1);

                if (right - left < len) {
                    len = right - left;
                    minLeft = left;
                }

                left++;
                b = true;
            }
        }

        return b ? s.substring(minLeft, minLeft + len) : "";
    }

    private int get(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            return map.get(c);
        } else {
            return 0;
        }
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tHashMap.entrySet()) {
            if (!sHashMap.containsKey(entry.getKey())
                    || sHashMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
