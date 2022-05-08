package com.leetcode.problems.easy;

public final class SumZero {
    public static int[] generate(int n) {
        if(n == 1) {
            return new int[]{0};
        }

        int[] ans = new int[n];
        for(int i=1; i<=n/2; i++) {
            ans[i-1]=i;
            ans[n-i]=i * -1;
        }

        if(n % 2 != 0) {
            ans[n/2]=0;
        }

        return ans;
    }
}
