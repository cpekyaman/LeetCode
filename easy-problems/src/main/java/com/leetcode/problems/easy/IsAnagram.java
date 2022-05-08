package com.leetcode.problems.easy;

public class IsAnagram {
    public boolean determine(String s, String t) {
        int[] counts = new int[26];

        char base = 'a';
        for(int i=0; i < s.length(); i++) {
            counts[s.charAt(i)-base] += 1;
        }
        for(int i=0; i < t.length(); i++) {
            counts[t.charAt(i)-base] -= 1;
        }

        for(int c : counts) {
            if(c != 0) {
                return false;
            }
        }
        return true;
    }
}
