package com.leetcode.problems.hard;

import java.util.Arrays;

public class PaintHouseV3 {
    private static final int MAX_COST = 1000001;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target+1];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], MAX_COST);
            }
        }

        if(houses[0] != 0) {
            dp[0][houses[0]-1][1] = 0;
        } else {
            for(int i=1; i<=n; i++) {
                dp[0][i-1][1] = cost[0][i-1];
            }
        }

        for(int h=1; h<m; h++) {
            for(int c=1; c<=n; c++) {
                if(houses[h] != 0 && houses[h] != c) {
                    continue;
                }

                for(int nb=1; nb<=Integer.min(target, h+1); nb++) {
                    int minCost = MAX_COST;
                    for(int pc=1; pc<=n; pc++) {
                        if(pc != c) {
                            minCost = Integer.min(minCost, dp[h-1][pc-1][nb-1]);
                        } else {
                            minCost = Integer.min(minCost, dp[h-1][c-1][nb]);
                        }
                    }
                    dp[h][c-1][nb] = minCost + (houses[h] != 0 ? 0 : cost[h][c-1]);
                }
            }
        }

        int minCost = MAX_COST;
        for(int c=0; c<n; c++) {
            minCost = Integer.min(minCost, dp[m-1][c][target]);
        }
        return minCost == MAX_COST ? -1 : minCost;
    }
}
