package com.leetcode.problems.easy;

public class KthMissingPositive {
    public int find(int[] arr, int k) {
        int missing=0;
        for(int i=0;i<arr.length;i++) {
            missing = arr[i] - i - 1;
            if(missing == k) {
                return arr[i] - 1;
            } else if(missing > k) {
                return arr[i]-(missing-k+1);
            }
        }

        return arr[arr.length-1] + k - missing;
    }
}
