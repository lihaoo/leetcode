package leetcode;

public class _14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        int a = 0;
        char i;

        while (true) {
            boolean b = false;
            if (a == strs[0].length()) {
                break;
            }
            i = strs[0].charAt(a);
            for (String s : strs) {
                if (a == s.length() || i != s.charAt(a)) {
                    b = true;
                }
            }
            if (b) {
                break;
            }
            a++;
        }

        return strs[0].substring(0, a);
    }
}
