package com.leetcode.problems.hard;

import java.util.HashMap;
import java.util.Map;

public final class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        if(s.length() == 0 || t.length() == 0) {
            return "";
        }

        // required occurences dict for t
        Map<Character, Integer> tchars = new HashMap<>();
        for(char c : t.toCharArray()) {
            tchars.compute(c, (k,v) -> v == null ? 1 : v+1);
        }

        // sliding window for s
        int left=0, right=0, completed=0;
        // seen chars dict for s
        Map<Character, Integer> schars = new HashMap<>();
        // used for result
        int start=0, end=0, minLen=Integer.MAX_VALUE;

        while(right < s.length()) {
            char curr = s.charAt(right);

            // if this char is in t and we have seen enough of it,
            // we have one more char completely seen.
            if(tchars.containsKey(curr)) {
                if(schars.compute(curr, (k,v) -> v == null ? 1 : v+1).equals(tchars.get(curr))) {
                    completed++;
                }
            }

            // not there yet, just extend the range and continue
            if(completed < tchars.size()) {
                right++;
                continue;
            }

            // as long as we still have complete set, narrow the range and update result
            while(completed == tchars.size() && left<=right) {
                char lchar = s.charAt(left);
                if(right-left+1 < minLen) {
                    minLen = right-left+1;
                    start = left;
                    end = right;
                }

                // a char from t is going out of window
                if(schars.containsKey(lchar)) {
                    if(schars.compute(lchar, (k,v) -> v == null ? 1 : v-1) < tchars.get(lchar)) {
                        completed--;
                    }
                }

                // narrowing the window
                left++;
            }

            // extending the window
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end+1);
    }
}
