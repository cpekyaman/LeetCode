package com.leetcode.problems.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> ans = new LinkedList<>();

        int start=0, end=0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1] + 1) {
                if(start == end) {
                    ans.add(Integer.toString(nums[start]));
                } else {
                    ans.add(nums[start] + "->" + nums[end]);
                }
                start = i;
                end = i;
            } else {
                end++;
            }
        }

        if(start == end) {
            ans.add(Integer.toString(nums[start]));
        } else {
            ans.add(nums[start] + "->" + nums[end]);
        }

        return ans;
    }
}
