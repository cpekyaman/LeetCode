package com.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

public final class LengthOfLongestSubstring {
    public static int find(String s) {
        Set<Character> seen = new HashSet<>();
        int left=0, maxLen=0;
        for(int i=0; i<s.length() && left < s.length(); i++) {
            while(left < s.length() && seen.contains(s.charAt(i))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(i));
            maxLen = Integer.max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
