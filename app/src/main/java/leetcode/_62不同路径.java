package leetcode;

public class _62不同路径 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            ints[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            ints[0][i] = 1;
        }

        return f(ints, m - 1, n - 1);
    }

    private int f(int[][] ints, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (ints[m][n] != 0) {
            return ints[m][n];
        }

        ints[m][n] = f(ints, m - 1, n) + f(ints, m, n - 1);
        return ints[m][n];
    }
}


// f(m,n) = f(m-1,n)+f(m,n-1)