package com.leetcode.problems.hard;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) {
            return true;
        }

        int sp=0, pp=0, starPos=-1, starMatchPos=-1;

        while(sp < s.length()) {
            // a single char match
            if(pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if(pp < p.length() && p.charAt(pp) == '*') {
                // a star, remember where we see it and continue
                starPos=pp;
                starMatchPos=sp;
                pp++;
            } else if(starPos >= 0) {
                // after a star, we continue normally until we found no-match.
                // at that point, we fallback to last * position and extend our match in s.
                // then continue again.
                pp=starPos+1;
                starMatchPos++;
                sp=starMatchPos;
            } else {
                return false;
            }
        }

        while(pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }

        return sp == s.length() && pp == p.length();
    }
}
