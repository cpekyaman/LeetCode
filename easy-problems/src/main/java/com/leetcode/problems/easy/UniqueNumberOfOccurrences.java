package com.leetcode.problems.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class UniqueNumberOfOccurrences {
    public boolean determine(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i : arr) {
            counts.put(i, counts.getOrDefault(i, 0)+1);
        }

        return new HashSet<>(counts.values()).size() == counts.size();
    }
}
