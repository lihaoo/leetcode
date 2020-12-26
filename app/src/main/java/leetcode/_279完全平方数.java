package leetcode;

public class _279完全平方数 {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n < 4) {
            return n;
        }

        int[] f = new int[n + 1];

        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        f[4] = 1;

        for (int i = 5; i < n + 1; i++) {
            int max = 1;
            while ((max + 1) * (max + 1) <= i) {
                max++;
            }

            if (max * max == i) {
                f[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                while (max > 0) {
                    min = Math.min(f[i - max * max], min);
                    max--;
                }
                f[i] = min + 1;
            }
        }

        return f[n];
    }
}
