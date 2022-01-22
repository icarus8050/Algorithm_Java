package leetcode;

/**
 * 121. Best Time to Buy and Sell Stock (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int result = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                result = Math.max(result, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return result;
    }

    /**
     * 이것도 시간 초과..
     */
    public int maxProfit_TimeLimitExceeded_2(int[] prices) {
        int result = 0;
        if (prices.length <= 1) return 0;

        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minPrice) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] - prices[i] > result) {
                        result = prices[j] - prices[i];
                    }
                }
            }
        }
        return result;
    }

    /**
     * O(n^2) 시간 초과..
     */
    public int maxProfit_TimeLimitExceeded_1(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > result) {
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }
}
