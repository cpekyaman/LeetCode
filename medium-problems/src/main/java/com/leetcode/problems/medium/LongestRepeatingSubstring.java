package com.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        int n = S.length();

        // find a candidate length.
        // for each len: check if there is any substr(i,i+len) which repeats.
        // and adjust search bounds whether we found any substrings or not.
        int start = 1, end = n - 1;
        int maxLen = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (search(mid, S)) {
                // we found repeating substr at len=mid.
                // maybe there is another with len>mid.
                maxLen = mid;
                start = mid + 1;
            } else {
                // longer substr don't repeat, search for shorter ones.
                end = mid - 1;
            }
        }
        return maxLen;
    }

    public boolean search(int len, String S) {
        // check if any substr of length len repeats.
        // this method allows overlap of substrings.
        // second occurrence can start within the bound of first.
        Set<String> seen = new HashSet<>();
        for (int i = 0; i + len <= S.length(); i++) {
            String curr = S.substring(i, i+len);
            if (! seen.add(curr)) {
                return true;
            }
        }
        return false;
    }

    private int solveDP(String S) {
        int n = S.length();
        //dp[i][j] means # of repeated chars for substrings ending at i and j
        int[][] dp = new int[n + 1][n + 1];

        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // we have substr(1,i) == substr(i,j) if:
                // char(i)=char(j) and substr(1,i-1) == substr(1,j-1)
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
