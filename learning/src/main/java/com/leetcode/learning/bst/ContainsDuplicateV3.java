package com.leetcode.learning.bst;

import java.util.TreeSet;

public final class ContainsDuplicateV3 {
    public static boolean contains(int[] nums, int k, int t) {
        TreeSet<Long> ordered = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            Long num = Long.valueOf(nums[i]);
            Long ceil = ordered.ceiling(num);
            if(ceil != null && ceil <= num + t) {
                return true;
            }

            Long floor = ordered.floor(num);
            if(floor != null && num <= floor + t) {
                return true;
            }

            ordered.add(num);
            if(ordered.size() > k) {
                ordered.remove(Long.valueOf(nums[i-k]));
            }
        }

        return false;
    }
}
