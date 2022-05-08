package com.leetcode.problems.easy;

public final class ReverseIntBits {
    public static int reverse(int n) {
        int ans = 0;
        int iter = 0;
        while(iter < 32) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
            iter++;
        }
        return ans;
    }
}
