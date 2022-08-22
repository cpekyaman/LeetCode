package com.leetcode.problems.medium;

public final class MaxConsecutiveOnesV2 {
    public static int find(int[] nums) {
        int max=0, count=0, prezero=-1;
        for(int num : nums) {
            if(num == 1) {
                count++;
            } else {
                if(prezero < 0) {
                    prezero=count;
                } else {
                    max = Integer.max(max, count);
                    count=count-prezero-1;
                }
                count++;
            }
        }
        return Integer.max(max, count);
    }
}
