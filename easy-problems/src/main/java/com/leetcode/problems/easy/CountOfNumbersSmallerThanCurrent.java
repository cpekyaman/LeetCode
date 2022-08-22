package com.leetcode.problems.easy;

import java.util.Arrays;

public class CountOfNumbersSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // we get the sorted version of array and simply iterate over the array.
        // count of numbers < nums[i] is simply i when we iterate over sorted array.
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        // this could be hashmap, we use an array as the range is very small.
        int[] counts = new int[101];
        Arrays.fill(counts, -1);

        for(int i=0; i<sorted.length; i++) {
            // if counts value is set, it means we have repeating value.
            // in that case, smallest i is the count of numbers < sorted[i].
            if(counts[sorted[i]] < 0) {
                counts[sorted[i]]=i;
            }
        }

        // fill the ans by using nums[i] as lookup key for counts array.
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            ans[i] = counts[nums[i]];
        }
        return ans;
    }
}
