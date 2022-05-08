package com.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

public final class ContainsDuplicateV2 {
    public boolean check(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(seen.contains(nums[i])) {
                return true;
            }
            seen.add(nums[i]);
            if(seen.size() > k) {
                seen.remove(nums[i-k]);
            }
        }
        return false;
    }
}
