package com.leetcode.problems.easy;

public final class MaximumPopulationYear {
    public static int find(int[][] logs) {
        final int minBirth = 1950;
        final int maxDeath = 2050;

        int[] years = new int[maxDeath - minBirth + 1];

        for(int[] log : logs) {
            years[log[0]-1950] += 1;
            years[log[1]-1950] -= 1;
        }

        for(int i = 1; i < years.length; i++) {
            years[i] += years[i-1];
        }

        int min = minBirth, maxPop = 0;
        for(int i=0;i<years.length;i++) {
            if(years[i] > maxPop) {
                maxPop = years[i];
                min = minBirth + i;
            }
        }
        return min;
    }
}
