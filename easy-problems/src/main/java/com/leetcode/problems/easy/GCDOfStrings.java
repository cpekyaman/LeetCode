package com.leetcode.problems.easy;

public class GCDOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2)) {
            return str1;
        }

        // if str1 = n * t and str2 = m * t, their concat should be equal
        if(! (str1 + str2).equals(str2 + str1) ) {
            return "";
        }

        // for a prefix to be gcd of both strings, its length should be gcd of their lengths.
        // as you need to have len(str1) = n * len(t) and len(str2) = m * len(t)
        int commonLen = gcd(str1.length(), str2.length());

        String prefix = str1.substring(0, commonLen);
        if(prefix.equals(str2.substring(0, commonLen))) {
            return prefix;
        }
        return "";
    }

    private int gcd(int a, int b) {
        if(a == b) {
            return a;
        } else if(a > b) {
            return gcd(a-b, b);
        } else {
            return gcd(b-a, a);
        }
    }
}
