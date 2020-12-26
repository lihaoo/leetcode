package leetcode;

public class _5最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = -1;
            }
        }

        int max = Integer.MIN_VALUE;
        String s1 = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int z = getDp(s, dp, i, j);
                if (max < z) {
                    max = z;
                    s1 = s.substring(i, j + 1);
                }
            }
        }

        return s1;
    }

    private int getDp(String s, int[][] dp, int y, int x) {
        if (x < 0 || y < 0 || y >= dp.length || x >= dp.length) {
            return 0;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        if (x == y) {
            dp[y][x] = 1;
            return dp[y][x];
        }

        if (y + 1 == x) {
            dp[y][x] = s.charAt(y) == s.charAt(x) ? 2 : 0;
        }

        if (y > x || getDp(s, dp, y + 1, x - 1) == 0) {
            dp[y][x] = 0;
            return dp[y][x];
        }

        dp[y][x] = s.charAt(y) == s.charAt(x) ? getDp(s, dp, y + 1, x - 1) + 2 : 0;

        return dp[y][x];
    }
}
