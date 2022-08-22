package com.leetcode.problems.hard;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we will base our binary search on the smaller array.
        int[] smallArr = nums2, largeArr=nums1;
        if(nums1.length < nums2.length) {
            smallArr = nums1;
            largeArr = nums2;
        }

        final int szLarge = largeArr.length;
        final int szSmall = smallArr.length;

        // we will be searching for cut positions.
        // a cut position can be one of the numbers or between two numbers (gaps).
        // if we see those gaps as indexes, we have 0-2N possible cut indexes (2N+1 cut positions).

        // we will have two imaginary cut positions from two arrays with certain rules (in the loop).
        // which will give us the median of these two sorted arrays.
        int low=0, high=szSmall*2;
        while(low <= high) {
            // pick a mid as candidate median for small array.
            int midSmall = low + (high - low) / 2;
            // total cut positions: (2*szLarge + 1) + (2*szSmall + 1).
            // elements on both sides of the cut(s): (szLarge + szSmall) (+2 cut elements).

            // this is the candidate mid for large array according to above.
            int midLarge = szLarge + szSmall - midSmall;

            // for each individual cut at i, left is (i-1)/2 and right is i/2.
            // for odd i: they are the same; for even i: they are 1 apart.
            // be careful of boundaries.
            double leftLarge = midLarge == 0 ? Integer.MIN_VALUE : largeArr[(midLarge-1)/2];
            double leftSmall = midSmall == 0 ? Integer.MIN_VALUE : smallArr[(midSmall-1)/2];

            double rightLarge = midLarge == 2*szLarge ? Integer.MAX_VALUE : largeArr[midLarge/2];
            double rightSmall = midSmall == 2*szSmall ? Integer.MAX_VALUE :smallArr[midSmall/2];

            // all elements at the left from each array should be less than right side from opposite array.
            // we move the possible cut in small array according to which left is greater than which right.
            if(leftLarge > rightSmall) {
                low = midSmall + 1;
            } else if(leftSmall > rightLarge) {
                high = midSmall - 1;
            } else {
                // largest on the left and smallest on the right give correct left and right of median.
                return (Double.max(leftLarge, leftSmall) + Double.min(rightLarge, rightSmall)) / 2;
            }
        }

        return -1.0;
    }
}
