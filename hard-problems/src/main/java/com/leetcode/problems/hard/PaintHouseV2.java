package com.leetcode.problems.hard;

public final class PaintHouseV2 {
    public int minCost(int[][] costs) {
        final int n = costs.length;
        final int k = costs[0].length;

        int[] prev = new int[k];
        for(int i=0; i<k; i++) {
            prev[i] = costs[0][i];
        }

        for(int h=1; h<n; h++) {
            int[] curr = new int[k];
            for(int c=0; c<k; c++) {
                curr[c] = costs[h][c] + min(prev, c);
            }
            prev = curr;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            min = Integer.min(min, prev[i]);
        }
        return min;
    }

    private int min(int[] prev, int color) {
        int min=Integer.MAX_VALUE;
        for(int c=0; c<prev.length; c++) {
            if(c == color) {
                continue;
            }
            min = Integer.min(min, prev[c]);
        }
        return min;
    }
}
