package com.leetcode.problems.hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class MaximumFrequencyStack {
    private final Map<Integer, Integer> freq;
    private final Map<Integer, Deque<Integer>> buckets;
    private int maxFreq=0;

    public MaximumFrequencyStack() {
        this.freq = new HashMap<>();
        this.buckets = new HashMap<>();
    }

    public void push(int val) {
        int f = freq.compute(val, (k,v) -> v == null ? 1 : v+1);
        buckets.computeIfAbsent(f, k -> new LinkedList<>()).push(val);
        maxFreq = Math.max(f, maxFreq);
    }

    public int pop() {
        int val = buckets.get(maxFreq).pop();
        freq.compute(val, (k,v) -> v-1);
        if(buckets.get(maxFreq).isEmpty()) {
            buckets.remove(maxFreq);
            maxFreq--;
        }
        return val;
    }
}
