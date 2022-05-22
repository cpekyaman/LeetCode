package com.leetcode.problems.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public final class FrequencySort {
    public String sort(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            freqs.compute(c, (k,v) -> v == null ? 1 : v+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Comparator.comparing(freqs::get,
                                                                                    Comparator.reverseOrder()));
        maxHeap.addAll(freqs.keySet());

        StringBuilder result = new StringBuilder();
        while(! maxHeap.isEmpty()) {
            Character c = maxHeap.poll();
            int freq = freqs.get(c);
            while(freq>0) {
                result.append(c);
                freq--;
            }
        }
        return result.toString();
    }
}
