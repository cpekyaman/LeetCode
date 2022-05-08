package com.leetcode.problems.easy;

import java.util.*;

public final class SortArrayByFrequency {
    public static int[] sort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> sorted = new ArrayList<>(nums.length);
        for(int num : nums) {
            sorted.add(num);
            freq.compute(num, (k,v) -> v == null ? 1 : v+1);
        }

        sorted.sort((a, b) -> {
            int freqComp = freq.get(a).compareTo(freq.get(b));
            if(freqComp == 0) {
                return Integer.compare(b, a);
            }
            return freqComp;
        });

        int[] result = new int[nums.length];
        for (int i = 0; i < sorted.size(); i++) {
            result[i] = sorted.get(i);
        }
        return result;
    }
}
