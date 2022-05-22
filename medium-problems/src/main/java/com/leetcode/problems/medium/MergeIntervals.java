package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> merged = new LinkedList<>();
        int[] last = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if(last[1] >= curr[0]) {
                last[1] = Integer.max(last[1], curr[1]);
            } else {
                merged.add(last);
                last = curr;
            }
        }
        merged.add(last);

        int[][] result = new int[merged.size()][];
        for(int i=0; i<merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
