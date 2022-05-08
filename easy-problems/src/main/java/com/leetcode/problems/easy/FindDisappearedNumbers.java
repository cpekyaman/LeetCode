package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public final class FindDisappearedNumbers {
    public static List<Integer> find(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int target = Math.abs(nums[i])-1;
            nums[target] = Math.abs(nums[target])*-1;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
