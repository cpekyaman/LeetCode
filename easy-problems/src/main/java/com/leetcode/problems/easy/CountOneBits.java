package com.leetcode.problems.easy;

public final class CountOneBits {
    public static int count(int n) {
        int count=0;
        int mask=1;
        int iter=32;
        while(iter>0) {
            if((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
            iter--;
        }
        return count;
    }
}
