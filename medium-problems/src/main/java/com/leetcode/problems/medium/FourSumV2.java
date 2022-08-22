package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

// idea with ksum:
// add the sum of first half of k arrays into map recursively.
// try to find complement sum of remaining arrays recursively.
public final class FourSumV2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCounts = new HashMap<>();
        for(int a : nums1) {
            for(int b : nums2) {
                int sum = a + b;
                sumCounts.compute(sum, (k,v) -> v == null ? 1 : v+1);
            }
        }

        int cnt=0;
        for(int c : nums3) {
            for(int d : nums4) {
                int sum = -(c+d);
                cnt += sumCounts.getOrDefault(sum,0);
            }
        }
        return cnt;
    }
}
