package leetcode;

import java.util.List;

public final class _322零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }

    public int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem] != 0) {
            return count[rem];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int x = coinChange(coins, rem - coin, count);
            if (x >= 0) {
                min = Math.min(min, x + 1);
            }
        }

        if (min == Integer.MAX_VALUE) {
            count[rem] = -1;
        } else {
            count[rem] = min;
        }

        return count[rem];
    }



}

