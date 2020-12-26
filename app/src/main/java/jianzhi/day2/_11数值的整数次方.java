package jianzhi.day2;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 * <p>
 * 知识点：
 * 模运算 就是求余运算
 * </p>
 * 记住：
 * 快速幂算法
 */

public class _11数值的整数次方 {
    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * 快速幂算法
     *
     * @param base
     * @param exponent
     * @return
     */
    private long quickPower(double base, int exponent) {
        return 1;
    }
}
