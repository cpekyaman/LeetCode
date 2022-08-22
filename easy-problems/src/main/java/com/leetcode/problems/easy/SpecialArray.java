package com.leetcode.problems.easy;

public class SpecialArray {
    // alternative:
    // sort the array
    // pick x(0..n)
    // if nums[n-x] >= x && nums[n-x-1] < x => target found
    public int specialArray(int[] nums) {
        int[] counts = new int[nums.length+1];

        // find the count of occurrences of each num in nums.
        // each num that is >= nums.length counted as single num.
        // (as they are greater than all nums in array)
        for(int num : nums) {
            if(num >= nums.length) {
                counts[nums.length]++;
            } else {
                counts[num]++;
            }
        }

        // for each i starting from end:
        // counts[i+1] is the cumulative of counts of numbers greater than i.
        // counts[i] is the count of num where num=i.
        // if we found an i where cumulativeCount + count[i] == i, that's our target.
        int count=0;
        for(int i=counts.length-1; i>=0; i--) {
            count += counts[i];
            if(count == i) {
                return i;
            }
        }
        return -1;
    }
}
