package com.leetcode.problems.easy;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        // start from len(s) / 2 as candidate length of substring.
        // for each i, compare s to repeated candidate.
        for(int len=s.length()/2; len>0; len--) {
            if(s.length() % len == 0) {
                int strPtr=0, copyPtr=0;
                // while strPtr goes from 0 to len(s), copyPtr goes from 0 to len(copy).
                // so that we have comparisons like s(0)->copy(0), s(1)->copy(1) .. s(len)->copy(0) ..
                while(strPtr < s.length() && s.charAt(strPtr) == s.charAt(copyPtr)){
                    strPtr++;
                    copyPtr = (copyPtr+1) % len;
                }

                // if we reach here we found a match
                if(strPtr == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
