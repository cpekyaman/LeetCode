package com.leetcode.problems.hard;

public final class CountVowelPermutation {
    public int count(int n) {
        final int MOD = 1000000007;

        // 'a':0, 'e':1, 'i':2, 'o':3, 'u':4
        int[][] successors = {{1}, {0,2}, {0,1,3,4}, {2,4}, {0}};

        int[] prev = new int[successors.length];
        for(int i=0; i<prev.length; i++) {
            prev[i] = 1;
        }

        for(int len=1; len<n; len++) {
            int[] curr = new int[prev.length];
            for(int ch=0; ch<successors.length; ch++) {
                for(Integer next : successors[ch]) {
                    curr[next] = (curr[next] + prev[ch]) % MOD;
                }
            }
            prev = curr;
        }

        int total = 0;
        for(int cnt : prev) {
            total = (total + cnt) % MOD;
        }
        return total;
    }
}
