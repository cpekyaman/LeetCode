package com.leetcode.problems.hard;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // edit distance of len(substr1(i)) vs empty str is i.
        for(int i=1; i<=m; i++) {
            dp[i][0]=i;
        }

        // edit distance of len(substr2(j)) vs empty str is j.
        for(int j=1; j<=n; j++) {
            dp[0][j]=j;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                // if current chars are the same, we don't need any additional edit.
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // otherwise, we need the min of one from:
                    // replace, insert or delete edit paths.
                    dp[i][j] = 1 + Integer.min(dp[i-1][j-1],
                                               Integer.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}
