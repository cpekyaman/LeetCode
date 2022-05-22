package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class FindDuplicates {
    public static List<Integer> find(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index-1] < 0) {
                ans.add(index);
            } else {
                nums[index-1] *= -1;
            }
        }
        return ans;
    }
}
