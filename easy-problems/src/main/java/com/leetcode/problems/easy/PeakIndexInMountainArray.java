package com.leetcode.problems.easy;

public final class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int left=1, right=arr.length-2;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if(arr[mid-1] < arr[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
