package com.leetcode.problems.hard;

public class PalindromePartitionV2 {
    public int minCut(String s) {
        Integer[][] memoCuts = new Integer[s.length()][s.length()];
        Boolean[][] memoPalindrome = new Boolean[s.length()][s.length()];

        return minCuts(s, 0, s.length()-1, memoCuts, memoPalindrome);
    }

    private int minCuts(String s, int start, int end,
                        Integer[][] memoCuts, Boolean[][] memoPalindrome) {

        if(start == end || isPalindrome(s, start, end, memoPalindrome)) {
            return 0;
        }

        if(memoCuts[start][end] != null) {
            return memoCuts[start][end];
        }

        int minCuts = end-start;
        for(int cutPos=start; cutPos<=end; cutPos++) {
            if(isPalindrome(s, start, cutPos, memoPalindrome)) {
                minCuts = Integer.min(minCuts, 1+minCuts(s, cutPos+1, end, memoCuts, memoPalindrome));
            }
        }

        memoCuts[start][end]=minCuts;
        return minCuts;
    }

    private boolean isPalindrome(String s, int start, int end, Boolean[][] memoPalindrome) {
        if(start >= end) {
            return true;
        }

        if(memoPalindrome[start][end] != null) {
            return memoPalindrome[start][end];
        }

        memoPalindrome[start][end] = s.charAt(start) == s.charAt(end)
                && isPalindrome(s, start+1, end-1, memoPalindrome);
        return memoPalindrome[start][end];
    }
}
