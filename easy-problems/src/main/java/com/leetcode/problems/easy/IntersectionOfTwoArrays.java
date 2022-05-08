package com.leetcode.problems.easy;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] find(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pos1 = 0, pos2 = 0;
        Set<Integer> intersection = new HashSet<>();
        while(pos1 < nums1.length && pos2 < nums2.length) {
            if(nums1[pos1] == nums2[pos2]) {
                intersection.add(nums1[pos1]);
                pos1++;
                pos2++;
            } else if (nums1[pos1] < nums2[pos2]) {
                pos1++;
            } else {
                pos2++;
            }
        }

        int[] results = new int[intersection.size()];
        int pos = 0;
        for (Integer num : intersection) {
            results[pos++] = num;
        }
        return results;
    }
}
