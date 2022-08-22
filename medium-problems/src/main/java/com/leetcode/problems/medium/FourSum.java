package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// this is probably a hard, not medium
public final class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(nums, target, 0, 4);
    }

    private List<List<Integer>> ksum(int[] nums, int target, int start, int k) {
        if(start == nums.length-1) {
            return Collections.emptyList();
        }

        int avg = target / k;
        if(avg < nums[start] || avg > nums[nums.length-1]) {
            return Collections.emptyList();
        }

        if(k == 2) {
            return twoSum(nums, target, start);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=start; i<nums.length-1; i++) {
            if(i == start || nums[i]!=nums[i-1]) {
                for(List<Integer> subSum : ksum(nums, target-nums[i], i+1, k-1)) {
                    ans.add(new ArrayList<>());
                    ans.get(ans.size()-1).add(nums[i]);
                    ans.get(ans.size()-1).addAll(subSum);
                }
            }
        }
        return ans;
    }

    // we can also use hashmap approach here
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        int lo=start, hi=nums.length-1;
        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum > target || (hi < nums.length-1 && nums[hi]==nums[hi+1])) {
                hi--;
            } else if(sum < target || (lo > start && nums[lo]==nums[lo-1])) {
                lo++;
            } else {
                ans.add(List.of(nums[lo++], nums[hi--]));
            }
        }
        return ans;
    }
}
