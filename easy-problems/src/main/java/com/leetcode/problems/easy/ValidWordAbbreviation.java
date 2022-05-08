package com.leetcode.problems.easy;

public final class ValidWordAbbreviation {
    public boolean determine(String word, String abbr) {
        int wordLen = word.length();
        int abbrLen = abbr.length();

        int wpos = 0, apos = 0;
        char achar;
        int skipLen = 0;
        while(apos < abbrLen) {
            achar = abbr.charAt(apos);
            if(Character.isDigit(achar)) {
                if(skipLen == 0 && achar == '0') {
                    return false;
                }
                skipLen = skipLen * 10 + Character.getNumericValue(achar);
                apos++;
            } else if(skipLen > 0) {
                wpos += skipLen;
                skipLen = 0;
            } else if(wpos >= wordLen || word.charAt(wpos) != abbr.charAt(apos)) {
                return false;
            } else {
                wpos++;
                apos++;
            }
        }

        return (wpos + skipLen) == wordLen && apos == abbrLen;
    }
}
