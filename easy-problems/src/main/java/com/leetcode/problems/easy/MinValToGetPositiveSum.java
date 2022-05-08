package com.leetcode.problems.easy;

public final class MinValToGetPositiveSum {
    public int solve(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }

        if(min > 0) {
            return 1;
        }
        return Math.abs(min) + 1;
    }
}
