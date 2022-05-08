package com.leetcode.problems.easy;

public final class BackspaceStringCompare {
    public static boolean compare(String s, String t) {
        int ps = s.length()-1;
        int pt = t.length()-1;

        while(ps >= 0 || pt >= 0) {

            int skip = 0;
            while(ps >= 0) {
                if(s.charAt(ps)=='#') {
                    skip++;
                    ps--;
                } else if(skip > 0){
                    skip--;
                    ps--;
                } else {
                    break;
                }
            }

            skip = 0;
            while(pt >= 0) {
                if(t.charAt(pt)=='#') {
                    skip++;
                    pt--;
                } else if(skip > 0){
                    skip--;
                    pt--;
                } else {
                    break;
                }
            }

            if(ps >= 0 && pt >= 0 && s.charAt(ps) != t.charAt(pt)) {
                return false;
            }

            if((ps >= 0) != (pt >= 0)) {
                return false;
            }

            ps--;
            pt--;
        }

        return true;
    }
}
