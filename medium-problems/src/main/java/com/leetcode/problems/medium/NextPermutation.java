package com.leetcode.problems.medium;

public final class NextPermutation {
    public void find(int[] nums) {
        // find a point where nums[i] < nums[i+1]
        int i = nums.length-2;
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }

        if(i >= 0) {
            // swap the element we found with the next largest number on the right
            int j = nums.length-1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // numbers right of the swap point is in decreasing order
        // we reverse the order to find min next permutation
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i=start, j = nums.length-1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
