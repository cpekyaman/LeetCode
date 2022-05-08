package com.leetcode.problems.easy;

import java.util.Arrays;

public final class MajorityElement {
    public static int find(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        return nums[n/2];
    }

    public static int boyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
