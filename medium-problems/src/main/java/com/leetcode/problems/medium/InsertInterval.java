package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }

        int n = intervals.length, idx=0;
        List<int[]> result = new ArrayList<>();

        // add all intervals that end before newinterval starts.
        while(idx < n && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx]);
            idx++;
        }

        // this is mostly the solution from merge intervals problem.
        // as long as we have overlapping interval with new one, merge them.
        // updating the interval bound with min/max deals with multiple possible overlap cases.
        while(idx < n && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Integer.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Integer.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        result.add(newInterval);

        // add the remaining intervals (which start after merged newInterval).
        while(idx < n) {
            result.add(intervals[idx++]);
        }

        // build the result array from intermediary list.
        int[][] ans = new int[result.size()][];
        for(int i=0; i<result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
