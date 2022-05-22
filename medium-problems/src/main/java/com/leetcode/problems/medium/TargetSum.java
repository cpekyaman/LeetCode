package com.leetcode.problems.medium;

import java.util.Arrays;

public final class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return findTopDown(nums, target);
    }

    public int findTopDown(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();

        int[][] dp = new int[nums.length][2*total + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findTopDownRecurse(nums, target, total, 0, 0, dp);
    }

    private int findTopDownRecurse(int[] nums, int target, int total, int sum, int index, int[][] dp) {
        if(index == nums.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        if(dp[index][sum+total] < 0) {
            dp[index][sum+total] = findTopDownRecurse(nums, target, total, sum-nums[index], index+1, dp)
                    + findTopDownRecurse(nums, target, total, sum+nums[index], index+1, dp);
        }

        return dp[index][sum+total];
    }
}
