package com.leetcode.problems.hard;

public final class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        // if the array does not contain 1, we return 1 immediately.
        // as it is the minimum positive integer already.
        boolean minFound = false;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                minFound = true;
            }

            // replace out of range values with one
            if(nums[i]<=0 || nums[i]>nums.length) {
                nums[i]=1;
            }
        }

        // we don't have 1 in the array, return
        if(! minFound) {
            return 1;
        }

        // converting all numbers that correspond to a num[i] to negative.
        // if there is a missing number, idx corresponding to that number will stay positive.
        for(int i=0; i<nums.length; i++) {
            // since we replaced all out of range vals with 1,
            // min index is 1 and max is nums.length (n)
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0) {
                nums[idx] = -1 * nums[idx];
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }

        // this means all numbers from 1..n are present
        return nums.length + 1;
    }
}
