package com.leetcode.problems.hard;

public final class MaximumVacationDays {
    public static int maxVacationDays(int[][] flights, int[][] days) {
        // no vacations at all
        if(days.length == 0) {
            return 0;
        }

        final int cityCount = days.length;
        final int weekCount = days[0].length;

        // we calculate max vacation days if we start on city i on week k.
        // that value depends on:
        // vacation days on city i on week k + max from week k+1 on city i
        // max(vacation days on city j on week k + max from week k+1 on city j) for each connected city.
        int[][] dp = new int[cityCount][weekCount+1];
        for(int week=weekCount-1; week>=0; week--) {
            for(int city=0; city<cityCount; city++) {
                dp[city][week] = days[city][week] + dp[city][week+1];
                for(int dest=0; dest<cityCount; dest++) {
                    if(flights[city][dest]==1) {
                        dp[city][week]=Integer.max(days[dest][week] + dp[dest][week+1], dp[city][week]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}
