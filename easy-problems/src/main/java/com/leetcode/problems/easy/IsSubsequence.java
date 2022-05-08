package com.leetcode.problems.easy;

import java.util.*;

public final class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        int ps = 0, pt = 0;
        while(ps < s.length() && pt < t.length()) {
            if(s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }

        return ps == s.length();
    }

    public static boolean[] isSubsequence(List<String> strings, String t) {
        Map<Character, LinkedList<Integer>> occurences = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            occurences.computeIfAbsent(t.charAt(i), k -> new LinkedList<>()).add(i);
        }

        boolean[] result = new boolean[strings.size()];
        for(int i=0; i<strings.size(); i++) {
            result[i] = isSubsequence(strings.get(i), occurences);
        }
        return result;
    }

    private static boolean isSubsequence(String s, Map<Character, LinkedList<Integer>> occurences) {
        int lastPos=0;
        for(char c : s.toCharArray()) {
            if(! occurences.containsKey(c) || occurences.get(c).isEmpty()) {
                return false;
            }

            // check if removing each consumed index is fine.
            // we may need to keep al indices and pick a suitable one depending on lastPos.
            int currentPos = occurences.get(c).removeFirst();
            if(currentPos < lastPos) {
                return false;
            } else {
                lastPos = currentPos;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(IsSubsequence.isSubsequence(List.of("abc", "axc"), "ahbgdc")));
    }
}
