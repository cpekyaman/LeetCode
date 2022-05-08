package com.leetcode.problems.easy;

public final class SingleNumber {
    public static int find(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum = sum ^ num;
        }
        return sum;
    }
}
