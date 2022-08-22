package com.leetcode.learning.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class FindMedianFromDataStream {
    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // a bit of balancing
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.isEmpty()) {
            return 0.0;
        }

        if(maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
