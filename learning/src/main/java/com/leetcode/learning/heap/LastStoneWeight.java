package com.leetcode.learning.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class LastStoneWeight {
    public static int find(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.naturalOrder());
        Arrays.stream(stones).forEach(pq::add);

        while(pq.size() > 1) {
            int one = pq.remove();
            int two = pq.remove();

            if(one != two) {
                pq.add(Math.abs(one-two));
            }
        }

        return pq.isEmpty() ? 0 : pq.remove();
    }
}
