package com.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

public final class WordPattern {
    public static boolean checkFollows(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String word = words[i];

            if(! charToWord.containsKey(c)) {
                if(wordToChar.containsKey(word) && wordToChar.get(word) != c) {
                    return false;
                }
                charToWord.put(c, word);
                wordToChar.put(word, c);
            } else if(! charToWord.get(c).equals(word)) {
                return false;
            }
        }

        return true;
    }
}
