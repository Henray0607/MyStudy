package leetcode_150;

/**
 * 188. 买卖股票的最佳时机 IV（限定交易次数 k=K）
 *
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[j][0]表示进行了j次交易后当前不持有股票的最大收益
        // dp[j][1]表示进行了j次交易后当前持有股票的最大收益
        int[][] dp = new int[k + 1][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < prices.length; i++) {
            dp[0][1] = Math.max(dp[0][1], -prices[i]);
            for (int j = 1; j <= k; j++) {
                // j次交易后不持有股票的最大收益，要么保持，要么从j-1次交易中持有的股票卖出
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);
                // j次交易后持有股票的最大收益，要么保持，要么从j次交易不持有股票买入
                dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
            }
        }
        return Math.max(0, Math.max(dp[k][0], dp[k][1]));
    }
}
