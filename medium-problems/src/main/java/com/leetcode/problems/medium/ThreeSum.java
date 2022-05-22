package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class ThreeSum {
    public static List<List<Integer>> sum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new LinkedList<>();
        for(int i=0;i < nums.length && nums[i] <= 0; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j=i+1,k=nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--;
                } else {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}
