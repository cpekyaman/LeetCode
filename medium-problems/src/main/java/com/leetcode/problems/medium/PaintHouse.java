package com.leetcode.problems.medium;

public final class PaintHouse {
    public int findMinCost(int[][] costs) {
        final int n=costs.length;
        int[][] dp = new int[n][3];

        for(int i=0; i<3; i++) {
            dp[0][i] = costs[0][i];
        }

        for(int h=1; h<n; h++) {
            dp[h][0] = costs[h][0] + Integer.min(dp[h-1][1], dp[h-1][2]);
            dp[h][1] = costs[h][1] + Integer.min(dp[h-1][0], dp[h-1][2]);
            dp[h][2] = costs[h][2] + Integer.min(dp[h-1][0], dp[h-1][1]);
        }

        return Integer.min(dp[n-1][0], Integer.min(dp[n-1][1], dp[n-1][2]));
    }
}
