package com.leetcode.problems.easy;

public final class SubstringSearch {
    public static int search(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }

        int h=0,n=0;
        while(h <= haystack.length()-needle.length()) {
            if(haystack.charAt(h+n) == needle.charAt(n)) {
                n++;
            } else {
                h++;
                n=0;
            }
            if(n == needle.length()) {
                return h;
            }
        }
        return -1;
    }
}
