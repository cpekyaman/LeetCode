package com.leetcode.problems.medium;

import java.util.*;

public final class GroupAnagrams {
    public static List<List<String>> group(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        int[] counts = new int[26];
        for(String s : strs) {
            Arrays.fill(counts, 0);
            for(char c : s.toCharArray()) {
                counts[c - 'a']+=1;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for(int i=0;i<counts.length;i++) {
                keyBuilder.append(counts[i]).append((char)(i+'a'));
            }
            String key = keyBuilder.toString();
            groups.computeIfAbsent(key, k -> new LinkedList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
