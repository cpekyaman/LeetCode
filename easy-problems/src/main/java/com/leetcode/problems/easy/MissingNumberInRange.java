package com.leetcode.problems.easy;

public final class MissingNumberInRange {
    public int find(int[] nums) {
        int numSum=0,indexSum=nums.length;
        for(int i=0;i<nums.length;i++) {
            indexSum += i;
            numSum += nums[i];
        }
        return indexSum-numSum;
    }
}
