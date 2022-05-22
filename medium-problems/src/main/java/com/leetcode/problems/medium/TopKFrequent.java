package com.leetcode.problems.medium;

import java.util.*;

public final class TopKFrequent {
    public List<String> find(String[] words, int k) {
        Map<String, Integer> freqs = new HashMap<>();
        for(String word : words) {
            freqs.compute(word, (w,c) -> c == null ? 1 : c+1);
        }

        PriorityQueue<String> sorted = new PriorityQueue<>((w1, w2) -> {
            int comp = Integer.compare(freqs.get(w1), freqs.get(w2));
            if(comp == 0) {
                return w2.compareTo(w1);
            }
            return comp;
        });

        for(String word : freqs.keySet()) {
            sorted.offer(word);
            if(sorted.size() > k) {
                sorted.poll();
            }
        }

        LinkedList<String> ans = new LinkedList<>();
        while(! sorted.isEmpty()) {
            ans.addFirst(sorted.poll());
        }
        return ans;
    }
}
