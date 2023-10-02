package leetcode_150;

/**
 * 121.买卖股票的最佳时机
 */
public class Solution121 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
