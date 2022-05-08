package com.leetcode.problems.easy;

public final class PivotIndex {
    // no need to use prefixSums array
    // can calculate total sum first
    // then, leftSum is always sum(0..i-1) and right sum (total-leftSum(i-1)-num(i))
    public int find(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[n+1];
        int sum = 0;
        prefixSums[0]=0;
        for(int i=1; i<=nums.length;i++) {
            sum += nums[i-1];
            prefixSums[i] = sum;
        }

        for(int i=0; i<nums.length;i++) {
            if(prefixSums[i] == prefixSums[n]-prefixSums[i]-nums[i]) {
                return i;
            }
        }

        return -1;
    }

}
