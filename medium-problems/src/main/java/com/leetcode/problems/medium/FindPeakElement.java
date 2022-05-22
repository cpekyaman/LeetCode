package com.leetcode.problems.medium;

public final class FindPeakElement {
    public int find(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }

    // since nums[-1] and nums[n] are -inf:
    // on increasing slope, there is a point we start decreasing on the right
    // on decreasing slope, there is a point we start decreasing on the left
    private int findPeak(int[] nums, int low, int high) {
        if(low == high) {
            return low;
        }

        int mid = low + (high-low)/2;
        if(mid > 0 && nums[mid] < nums[mid-1]) {
            return findPeak(nums, low, mid);
        } else if(mid < nums.length-1 && nums[mid] < nums[mid+1]){
            return findPeak(nums, mid+1, high);
        }
        return mid;
    }
}
