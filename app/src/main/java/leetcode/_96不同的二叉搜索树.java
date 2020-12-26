package leetcode;

public class _96不同的二叉搜索树 {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            int x = 0;
            f[i] = 0;
            while (x < i) {
                f[i] += f[x] * f[n - x - 1];
                x++;
            }
        }
        return f[n];
    }
}
