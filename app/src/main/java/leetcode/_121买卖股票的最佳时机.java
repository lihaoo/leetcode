package leetcode;

public class _121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int x1 = 0;
        int x2 = Math.max(0, prices[1] - prices[0]);
        int min = Math.min(prices[1], prices[0]);

        for (int i = 2; i < prices.length; i++) {
            int temp = x2;
            x2 = Math.max(x1, prices[i] - min);
            x1 = temp;

            min = Math.min(min, prices[i]);
        }

        return x2;
    }
}
