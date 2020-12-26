package jianzhi.day1;

/**
 * 跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * <p>
 * 递归的应用方法
 * <p>
 * 递归也能改成循环
 */

public class _07跳台阶 {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }


    public int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        int f1 = 1, f2 = 2, f3 = 3;

        for (int i = 3; i < target; i++) {
            int f = f2;
            f2 = f3;
            f1 = f;
            f3 = f1 + f2;
        }

        return f3;
    }
}
