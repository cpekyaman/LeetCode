package com.leetcode.problems.medium;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        if(s == null || s.length()==0 || words == null || words.length == 0) {
            return 0;
        }

        int count = 0;
        for(String word : words) {
            if(isWordStretchy(word, s)) {
                count++;
            }
        }
        return count;
    }

    private boolean isWordStretchy(String word, String s) {
        // first one is pointer for s, the second is pointer for word
        int sp=0, wp=0;

        // when we find matching char we check the lengths of the char sequences.
        // if they match according to stretchy rules, we move on.
        // when we find a non-match, we return false.
        while(sp < s.length() && wp < word.length()) {
            if(s.charAt(sp) != word.charAt(wp)) {
                return false;
            }

            char ch = word.charAt(wp);
            int wlen = charSeqLen(word, ch, wp);
            int slen = charSeqLen(s, ch, sp);

            // either we need to have equal length on both strings,
            // or stretched length in the second one >= 3
            if((slen != wlen && slen < 3) || slen < wlen) {
                return false;
            }

            wp+=wlen;
            sp+=slen;
        }

        // we should reach the end of both strings
        return sp == s.length() && wp == word.length();
    }

    private int charSeqLen(String w, char c, int start) {
        int len=0;
        while(start < w.length() && w.charAt(start) == c) {
            start++;
            len++;
        }
        return len;
    }
}
