package com.leetcode.problems.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakV2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();

        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Integer.max(word.length(), maxLen);
            words.add(word);
        }

        List<String> ans = new LinkedList<>();
        backtrack(words, s, 0, maxLen, new LinkedList<>(), ans);
        return ans;
    }

    private static void backtrack(Set<String> words, String s, int start, int maxLen,
                           LinkedList<String> current, List<String> ans) {

        if(start == s.length()) {
            ans.add(String.join(" ",current));
            return;
        }

        for(int i=start; i<=Integer.min(start+maxLen, s.length()); i++) {
            String word = s.substring(start, i);
            if(words.contains(word)) {
                current.addLast(word);
                backtrack(words, s, i, maxLen, current, ans);
                current.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(WordBreakV2.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }
}
