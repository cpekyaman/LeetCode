package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public final class FindCommonChars {
    public static List<String> find(String[] words) {
        // record how many times we see a char per word
        int[][] seen = new int[26][words.length];
        for(int w=0;w<words.length;w++) {
            String word = words[w];
            for(int c=0;c<word.length();c++) {
                seen[word.charAt(c)-'a'][w]+=1;
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i=0;i<seen.length;i++) {
            int[] counts = seen[i];
            // min number of times seen in all words
            int min = Integer.MAX_VALUE;
            for(int cnt : counts) {
                min = Integer.min(min, cnt);
            }
            // skip at least one word does not have char
            // otherwise add common occurance times
            while(min > 0) {
                ans.add(Character.toString((char)('a' + i)));
                min--;
            }
        }
        return ans;
    }
}
