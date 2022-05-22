package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class LetterCasePermutation {
    public List<String> permute(String s) {
        List<String> ans = new ArrayList<>();
        permutation(ans, new StringBuilder(), s, 0);
        return ans;
    }

    private void permutation(List<String> ans, StringBuilder current, String s, int start) {
        if(current.length() == s.length()) {
            ans.add(current.toString());
            return;
        }

        for(int i=start; i<s.length(); i++) {
            current.append(s.charAt(i));
            permutation(ans, current, s, i + 1);
            removeLast(current);

            if(! Character.isDigit(s.charAt(i))) {
                current.append(toggleCase(s.charAt(i)));
                permutation(ans, current, s, i + 1);
                removeLast(current);
            }
        }
    }

    private char toggleCase(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    }

    private void removeLast(StringBuilder sb) {
        sb.deleteCharAt(sb.length()-1);
    }
}
