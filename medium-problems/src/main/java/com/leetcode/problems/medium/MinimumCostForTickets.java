package com.leetcode.problems.medium;

public final class MinimumCostForTickets {
    private static final int[] durations = new int[]{1,7,30};

    public static int findMinCost(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length];
        return dp(days, costs, 0, memo);
    }

    private static int dp(int[] days, int[] costs, int day, Integer[] memo) {
        if(day >= days.length) {
            return 0;
        }

        if(memo[day] != null) {
            return memo[day];
        }

        int cost=Integer.MAX_VALUE;
        int next=day;
        for(int dur=0; dur<durations.length; dur++) {
            while(next < days.length && days[next] < days[day] + durations[dur]) {
                next++;
            }
            cost = Integer.min(cost, dp(days, costs, next, memo) + costs[dur]);
        }
        memo[day] = cost;
        return cost;
    }
}
