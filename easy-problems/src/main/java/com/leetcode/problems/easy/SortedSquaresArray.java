package com.leetcode.problems.easy;

public final class SortedSquaresArray {
    public static int[] square(int[] nums) {
        int[] result = new int[nums.length];

        int dest = result.length-1, left=0, right=nums.length-1;
        while(dest >= 0) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[dest--] = nums[left] * nums[left];
                left++;
            } else {
                result[dest--] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
}
