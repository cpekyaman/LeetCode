package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ArraySubsetsV2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        subset(nums, 0, subsets, new ArrayList<>());
        return subsets;
    }

    private static void subset(int[] nums, int i, List<List<Integer>> subsets, List<Integer> current) {
        subsets.add(new ArrayList<>(current));

        for(int j=i; j < nums.length; j++) {
            if(j > i && nums[j] == nums[j-1]) {
                continue;
            }

            current.add(nums[j]);
            subset(nums, j+1, subsets, current);
            current.remove(current.size()-1);
        }
    }
}
