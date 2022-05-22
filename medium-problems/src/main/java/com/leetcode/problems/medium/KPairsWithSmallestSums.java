package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public final class KPairsWithSmallestSums {
    public List<List<Integer>> find(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pairs = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.get(0) + l2.get(1),
                                                                                             l1.get(0) + l1.get(1)));

        for(int i=0; i<nums1.length && i<k; i++) {
            for(int j=0; j<nums2.length && j<k; j++) {
                if(pairs.size() < k) {
                    pairs.add(List.of(nums1[i], nums2[j]));
                } else {
                    if(nums1[i] + nums2[j] > pairs.peek().get(0) + pairs.peek().get(1)) {
                        break;
                    } else {
                        pairs.poll();
                        pairs.add(List.of(nums1[i], nums2[j]));
                    }
                }
            }
        }

        return new ArrayList<>(pairs);
    }
}
