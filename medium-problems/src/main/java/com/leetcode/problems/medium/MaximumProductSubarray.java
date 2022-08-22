package com.leetcode.problems.medium;

public class MaximumProductSubarray {
    // using a variation of kadane's algorithm
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        // we need to remember max and min upto i,
        // as a negative can flip max to min or vice versa.
        int runningMax = nums[0];
        int runningMin = nums[0];
        int globalMax = runningMax;

        for(int i=1; i<nums.length; i++) {
            int curr = nums[i];
            // we either reset our max to current num or we have a running sequence
            int currMax = Integer.max(curr, Integer.max(runningMax*curr, runningMin*curr));

            // we either reset our min to current num or we have a running sequence
            runningMin = Integer.min(curr, Integer.min(runningMax*curr, runningMin*curr));

            runningMax = currMax;

            // update global maximum
            globalMax = Integer.max(globalMax, runningMax);
        }

        return globalMax;
    }
}
