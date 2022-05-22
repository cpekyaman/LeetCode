package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class ArraySubsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        for(int sz=0; sz <= nums.length; sz++) {
            subset(subsets, new ArrayList<>(sz), nums, sz, 0);
        }

        return subsets;
    }

    private static void subset(List<List<Integer>> subsets,
                               List<Integer> current,
                               int[] nums, int sz, int curr) {

        if(current.size() == sz) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        for(int i=curr; i < nums.length; i++) {
            current.add(nums[i]);
            subset(subsets, current, nums, sz, i+1);
            current.remove(current.size()-1);
        }
    }
}
