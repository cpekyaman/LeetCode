package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class FindMissingRanges {
    public static List<String> find(int[] nums, int lower, int upper) {
        if(nums.length == 0) {
            return List.of(pairStr(lower-1, upper+1));
        }

        List<String> ans = new ArrayList<>();

        if(nums[0] > lower) {
            ans.add(pairStr(lower-1, nums[0]));
        }

        for(int i=1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] > 1) {
                ans.add(pairStr(nums[i-1], nums[i]));
            }
        }

        if(upper > nums[nums.length-1]) {
            ans.add(pairStr(nums[nums.length-1], upper+1));
        }

        return ans;
    }

    private static String pairStr(int lower, int upper) {
        int diff = upper - lower;
        if(diff > 2) {
            return (lower+1) + "->" + (upper-1);
        } else if(diff == 2) {
            return Integer.toString(lower+1);
        } else {
            return "";
        }
    }
}
