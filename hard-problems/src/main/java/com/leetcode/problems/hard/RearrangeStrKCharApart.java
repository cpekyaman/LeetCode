package com.leetcode.problems.hard;

import java.util.*;

public final class RearrangeStrKCharApart {
    public String rearrange(String s, int k) {
        if(k == 0) {
            return s;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()) {
            counts.compute(c, (key,v) -> v == null ? 1 : v+1);
        }

        PriorityQueue<Character> ordered = new PriorityQueue<>((c1, c2) -> Integer.compare(counts.get(c2), counts.get(c1)));
        ordered.addAll(counts.keySet());

        Deque<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        while(! ordered.isEmpty()) {
            Character c = ordered.poll();
            result.append(c);
            queue.offer(c);
            counts.compute(c, (key,v) -> v-1);
            if(queue.size() == k) {
                Character cc = queue.poll();
                if(counts.get(cc) > 0) {
                    ordered.add(cc);
                }
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}
