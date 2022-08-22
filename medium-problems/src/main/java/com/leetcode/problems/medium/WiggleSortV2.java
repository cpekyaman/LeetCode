package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.Random;

public final class WiggleSortV2 {
    private static final Random rand = new Random();

    public static void wiggleSort(int[] nums) {
        final int n = nums.length;
        // all numbers with i < medianIdx are less than nums[medianIdx].
        int median = quickSelect(nums, 0, n-1, n/2);

        int[] temp = new int[nums.length];
        // put each num > median at odd indices starting from 1.
        // put each num < median at even indices starting from end.
        int odd=1, even=nums.length % 2 == 0 ? nums.length-2 : nums.length-1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > median) {
                temp[odd]=nums[i];
                odd+=2;
            } else if(nums[i] < median) {
                temp[even]=nums[i];
                even-=2;
            }
        }

        // these loops mean there are items that equal to median (at least one, obviously).
        // we put these into the not processed odd / even positions (towards start and end).
        // since we process odd and even in opposite directions, two medians can't be put as neighbors by mistake.
        while(odd<nums.length){
            temp[odd]=median;
            odd+=2;
        }
        while(even>=0){
            temp[even]=median;
            even-=2;
        }

        // set nums values from temp reordered values.
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];
        }
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        if(low == high) {
            return nums[low];
        }

        int pivotIdx = partition(nums, low, high);
        if(pivotIdx == k) {
            return nums[pivotIdx];
        }

        if(pivotIdx < k) {
            return quickSelect(nums, pivotIdx+1, high, k);
        } else {
            return quickSelect(nums, low, pivotIdx-1, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivotIdx = low + rand.nextInt(high-low);
        int pivot = nums[pivotIdx];

        swap(nums, pivotIdx, high);

        int store=low;
        for(int i=low; i<=high; i++) {
            if(nums[i] < pivot) {
                swap(nums, store, i);
                store++;
            }
        }

        swap(nums, store, high);
        return store;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1,1,6,4};
        WiggleSortV2.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
