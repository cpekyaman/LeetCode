package com.leetcode.problems.medium;

import java.util.Random;

public final class FindKthLargestInArray {
    private final Random random = new Random();

    public int find(int[] nums, int k) {
        final int n = nums.length;
        quickSelect(nums, 0, n-1, n-k);
        return nums[n-k];
    }

    private void quickSelect(int[] nums, int low, int high, int k) {
        if(low == high) {
            return;
        }

        int pivotIndex = lomutoPartition(nums, low, high);
        if(pivotIndex == k) {
            return;
        } else if(pivotIndex < k) {
            quickSelect(nums, pivotIndex+1, high, k);
        } else {
            quickSelect(nums, low, pivotIndex-1, k);
        }
    }

    private int lomutoPartition(int[] nums, int low, int high) {
        int pivotIndex = low + random.nextInt(high-low);
        int pivot = nums[pivotIndex];

        swap(nums, high, pivotIndex);
        int store=low;
        for(int i=low; i<=high; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, store);
                store++;
            }
        }

        swap(nums, store, high);
        return store;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
