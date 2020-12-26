package jianzhi.day1;

/**
 * 斐波那契数列
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * <p>
 * <p>
 * 1,2,3,4,5,.:递增排列
 * 9,8,7,6,5.:递减排列
 * 1,2,3,3,4,5,8,8,.:非递减排列
 * 9,8,7,7,6,5,5,2,1,.:非递增排列
 */

public class _06斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public int Fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int x = 1, y = 1;
        for (int i = 2; i < n; i++) {
            int a = y;
            y = x + y;
            x = a;
        }

        return y;
    }
}

