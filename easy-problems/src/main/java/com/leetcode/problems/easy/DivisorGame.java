package com.leetcode.problems.easy;

public class DivisorGame {
    public boolean divisorGame(int n) {
        // dp represents the win chance when starting from i for each i in (0..n)
        boolean[] dp = new boolean[n+1];

        // we can't make a move for i<=1
        dp[0] = false;
        dp[1] = false;

        for(int i=2; i<=n; i++) {
            // we mark i as win if we find a j where i%j == 0 and i-j cannot win.
            // first check is the condition to make a move.
            // and second check means we don't give opponent winning move.
            for(int j=1; j<i; j++) {
                if(i % j == 0 && ! dp[i-j]) {
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
