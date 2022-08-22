package com.leetcode.problems.hard;

public final class RegexMatching {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return isMatch(s, 0, p, 0, memo);
    }

    private boolean isMatch(String s, int spos, String p, int ppos, Boolean[][] memo) {
        if(memo[spos][ppos] != null) {
            return memo[spos][ppos] == Boolean.TRUE;
        }

        // if we consumed the string, pattern should also be consumed
        if(ppos == p.length()) {
            memo[spos][ppos] = spos == s.length();
            return memo[spos][ppos];
        }

        // is the current chars match (considering the . wildcard)
        boolean match = spos < s.length() && (p.charAt(ppos) == s.charAt(spos) || p.charAt(ppos) == '.');

        if(ppos <= p.length()-2 && p.charAt(ppos+1) == '*') {
            // we either ignore .* part (as if 0 or more), or interpret it as one or more
            memo[spos][ppos] = isMatch(s, spos, p, ppos+2, memo)
                    || (match && isMatch(s, spos+1, p, ppos, memo));
        } else {
            // regular recursive call for the next part of string and pattern
            memo[spos][ppos] = match && isMatch(s, spos+1, p, ppos+1, memo);
        }

        return memo[spos][ppos];
    }
}
