package com.leetcode.problems.easy;

public final class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1, p2=n-1, dest=m+n-1;
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[dest--]=nums1[p1--];
            } else {
                nums1[dest--]=nums2[p2--];
            }
        }

        int ptr = p1 >= 0 ? p1 : p2;
        int[] rem = p1 >= 0 ? nums1 : nums2;
        while(dest >= 0) {
            nums1[dest--]=rem[ptr--];
        }
    }
}
