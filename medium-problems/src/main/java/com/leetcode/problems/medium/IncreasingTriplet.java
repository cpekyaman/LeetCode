package com.leetcode.problems.medium;

public final class IncreasingTriplet {
    public static boolean exists(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= first) {
                first = num;
            } else if(num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
