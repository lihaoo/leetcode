package leetcode;

public class _221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }

        if (matrix[0].length <= 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(get(dp, i - 1, j - 1), get(dp, i - 1, j)), get(dp, i, j - 1)) + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    private int get(int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        } else {
            return dp[i][j];
        }

    }
}
