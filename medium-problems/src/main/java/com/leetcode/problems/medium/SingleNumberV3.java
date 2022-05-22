package com.leetcode.problems.medium;

public final class SingleNumberV3 {
    public int[] find(int[] nums) {
        int bitmask = 0;
        for(int num : nums) {
            bitmask ^= num;
        }

        int setbit = bitmask & (-bitmask);

        int x=0;
        for(int num : nums) {
            if((num & setbit) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, bitmask^x};
    }
}
