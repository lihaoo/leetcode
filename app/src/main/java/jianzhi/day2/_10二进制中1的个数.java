package jianzhi.day2;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 知识点：原码反码补码
 * 计算机中存储的都是补码
 * 所有数字在计算机中的首位是符号位 0位正 1为负
 * 正数的原码反码补码都相同
 * 负数的反码 为原码的0换为1 1换为0，符号位不换
 * 负数的补码 为反码 +1
 * <p>
 * 位运算：
 * << 左位移 不动符号位
 * >> 右位移 不动符号位
 * >>> 无符号右移 符号位同时移动
 * 没有无符号左移运算
 * <p>
 * & 与运算
 * ^ 异或运算（为什么不叫相同运算则表示了 不同为1 相同为0）
 * <p>
 * 需要记住：整数的按位输出时的写法
 * </p>
 */

public class _10二进制中1的个数 {

    public int NumberOf1(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n >>> i) % 2 == 1 || (n >>> i) % 2 == -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 最优解法
     *
     * @param n
     * @return
     */
    public int NumberOf_1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

//    整数的按位输出时的写法
//    int n = Integer.MAX_VALUE;
//    n=-1;
//        for (int i = 31; i >= 0; i--) {
//        System.out.print(n >>> i&1);
//    }

}
