package com.leetcode.problems.medium;

public final class BestTimeToSellStockWithFee {
    public int maxProfit(int[] prices, int fee) {
        // [day][hold-no-hold]
        //int[][] dp = new int[prices.length][2];

        //dp[0][0] = 0;
        //dp[0][1] = -prices[0];

        // reduced the dp array solution to linear
        int cash=0, hold=-prices[0];

        for(int i=1; i<prices.length; i++) {
            cash = Integer.max(cash, hold + prices[i] - fee);
            hold = Integer.max(hold, cash - prices[i]);
            // dp[i][0] = Integer.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            // dp[i][1] = Integer.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return cash;
    }
}
