package com.leetcode.problems.medium;

public final class LongestPalindromeSubstring {
    public static String find(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int start=0, end=0;
        for(int i=0; i < s.length(); i++) {
            int len = Integer.max(palindromeAtCenter(s, i, i),
                                  palindromeAtCenter(s, i, i+1));

            if(len > end - start + 1) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end+1);
    }

    private static int palindromeAtCenter(String s, int left, int right) {
        int lp=left, rp=right;
        while(lp >= 0 && rp < s.length() && s.charAt(lp) == s.charAt(rp)) {
            lp--;
            rp++;
        }
        return rp - lp - 1;
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindromeSubstring.find("babad"));
    }
}
