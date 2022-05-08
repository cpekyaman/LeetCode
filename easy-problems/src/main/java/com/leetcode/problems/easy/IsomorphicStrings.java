package com.leetcode.problems.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class IsomorphicStrings {
    public static boolean check(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for(int i=0;i<len;i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if(! map.containsKey(sc) && ! used.contains(tc)) {
                map.put(sc, tc);
                used.add(tc);
            } else if(map.get(sc) == null || tc != map.get(sc)) {
                return false;
            }
        }
        return true;
    }
}
