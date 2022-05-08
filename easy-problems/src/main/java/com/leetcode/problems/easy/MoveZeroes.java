package com.leetcode.problems.easy;

public final class MoveZeroes {
    public void move(int[] nums) {
        int zeroP = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[zeroP++] = nums[i];
            }
        }

        for(int i = zeroP; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
