package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public final class FruitsIntoBaskets {
    public static int findMax(int[] fruits) {
        if(fruits == null || fruits.length == 0) {
            return 0;
        }

        // we want a subarray with at most 2 distinct elements
        final int distinctLimit = 2;

        // we will iterate over array and count items we collect as long as types<=2.
        // when we hit 3rd kind of fruit, we shrink our window from left until we again have 2.
        int max=0;
        int start=0;
        // instead of storing counts, we can store the last seen index of a fruit.
        // then we can simply remove the fruit with min index and move start to index+1.
        Map<Integer, Integer> counts = new HashMap<>();
        for(int end=0; end<fruits.length; end++) {
            counts.compute(fruits[end], (k,v) -> v == null ? 1 : v+1);
            while(counts.size() > distinctLimit) {
                if(counts.compute(fruits[start], (k,v) -> v-1) == 0) {
                    counts.remove(fruits[start]);
                }
                start++;
            }

            max = Integer.max(max, end-start+1);
        }

        return max;
    }
}
