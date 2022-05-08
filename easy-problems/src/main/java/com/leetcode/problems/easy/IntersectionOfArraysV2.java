package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IntersectionOfArraysV2 {
    public int[] find(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        // using smaller array to fill occurrences
        int[] arr = nums1.length < nums2.length ? nums1 : nums2;
        for(int num : arr) {
            numCounts.compute(num, (k,v) -> v == null ? 1 : v+1);
        }

        List<Integer> intersection = new ArrayList<>();
        // using larger array to iterate and find same nums
        arr = nums1.length < nums2.length ? nums2 : nums1;
        for(int num : arr) {
            Integer count = numCounts.get(num);
            if(count != null && count > 0) {
                intersection.add(num);
                numCounts.put(num, count-1);
            }
        }

        int[] ans = new int[intersection.size()];
        int i=0;
        for(Integer num : intersection) {
            ans[i++] = num;
        }
        return ans;
    }
}
