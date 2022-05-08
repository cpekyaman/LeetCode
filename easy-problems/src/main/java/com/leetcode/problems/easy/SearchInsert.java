package com.leetcode.problems.easy;

public final class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private static int search(int[] nums, int target, int low, int high) {
        if(low >= high) {
            return nums[low] < target ? low+1 : low;
        }

        int mid = low + (high-low) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] < target) {
            return search(nums, target, mid+1, high);
        } else {
            return search(nums, target, low, mid-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(searchInsert(new int[]{1,3}, 0));
    }
}
