package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NextGreaterElement {
    // use a stack for nums2, put each n < n-1 into stack
    // start popping as soon as you found n > n-1 and put (n,greaterN) to map
    // iterating over nums1 would be mostly same
    public int[] find(int[] nums1, int[] nums2) {
        Map<Integer, Integer> positions = new HashMap<>();

        int lastPos=0;
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<nums1.length;i++) {
            int numPos = -1,greater=-1;
            for(int j=positions.getOrDefault(nums1[i], lastPos); j < nums2.length; j++) {
                positions.putIfAbsent(nums2[j], j);
                lastPos=Integer.max(lastPos, j);
                if(numPos >= 0 && nums2[j] > nums1[i]) {
                    greater=nums2[j];
                    break;
                }

                if(nums2[j] == nums1[i]) {
                    numPos=j;
                }
            }
            results.add(greater);
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
