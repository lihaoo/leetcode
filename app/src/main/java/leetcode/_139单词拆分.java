package leetcode;

import java.util.HashSet;
import java.util.List;

public class _139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> strings = new HashSet<>(wordDict);

        boolean[] dp = new boolean[1 + s.length()];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && strings.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
