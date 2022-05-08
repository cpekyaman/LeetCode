package com.leetcode.problems.easy;

public final class RemoveDuplicates {
    public static int remove(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int insertPos=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        return insertPos;
    }
}
