package leetcode;

public class _365水壶问题 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z % gcd(x, y) == 0) {
            return true;
        }
        return false;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
