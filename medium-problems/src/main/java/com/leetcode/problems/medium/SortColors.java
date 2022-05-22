package com.leetcode.problems.medium;

public final class SortColors {
    public void sort(int[] nums) {
        int pZero=0, pTwo=nums.length-1, curr=0;
        while(curr <= pTwo) {
            if(nums[curr] == 0) {
                swap(nums, curr, pZero);
                pZero++;
                curr++;
            } else if(nums[curr] == 2) {
                swap(nums, curr, pTwo);
                pTwo--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
