package com.leetcode.problems.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class ConnectSticks {
    public static int connect(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        for(int s : sticks) {
            minHeap.add(s);
        }

        int cost=0;
        while(minHeap.size() > 1) {
            int s = minHeap.poll() + minHeap.poll();
            cost += s;
            minHeap.add(s);
        }
        return cost;
    }
}
