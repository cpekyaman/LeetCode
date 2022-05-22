package com.leetcode.problems.medium;

// Find First and Last Position of Element in Sorted Array
public final class SearchForNumberRange {
    public static int[] searchRange(int[] nums, int target) {
        final int n = nums.length;
        int[] range = new int[]{-1, -1};
        search(nums, target, 0, n-1, range);
        return range;
    }

    // trying to do 2 binarySearch in one, but it may be not be doing that properly
    // at least I can't formulate the proof that it is still logN instead of something like nlogN
    // may split search to do two binary search for min and max of range
    private static void search(int[] nums, int target, int left, int right, int[] range) {
        if(left > right) {
            return;
        }

        int mid = left + (right-left) / 2;
        if(nums[mid] == target) {
            if(range[0] < 0 || mid < range[0]) {
                range[0] = mid;
            }
            if(mid > range[1]) {
                range[1] = mid;
            }
            if(mid > left && nums[mid-1]==target) {
                search(nums, target, left, mid-1, range);
            }
            if(mid < right && nums[mid+1]==target) {
                search(nums, target, mid+1, right, range);
            }
        } else if(nums[mid] > target) {
            search(nums, target, left, mid-1, range);
        } else {
            search(nums, target, mid+1, right, range);
        }
    }
}
