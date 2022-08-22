package com.leetcode.problems.easy;

import java.util.Arrays;

public class FindDistanceBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count=0;
        for(int num : arr1) {
            if(valid(arr2, num, d)) {
                count++;
            }
        }
        return count;
    }

    // if we find any number with num-d <= x <= num+d, we exclude num.
    private boolean valid(int[] arr, int num, int d) {
        int start=0, end=arr.length-1;

        int from=num-d, to=num+d;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] >= from && arr[mid] <= to) {
                return false;
            } else if(arr[mid] < from) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return true;
    }
}
