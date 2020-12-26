package leetcode;

public class _70爬楼梯 {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = a + b;
            b = temp;
        }
        return a;

        Integer.MAX_VALUE
    }
}
