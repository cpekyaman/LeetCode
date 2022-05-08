package com.leetcode.problems.easy;

public final class ArrayFromPermutation {
    public static int[] build(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
