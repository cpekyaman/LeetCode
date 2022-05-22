package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class MeetingRoomsV2 {
    public int findMinRequired(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        PriorityQueue<int[]> meetings = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));

        for(int[] m : intervals) {
            if(meetings.isEmpty()) {
                meetings.add(m);
            } else {
                if(m[0] >= meetings.peek()[1]) {
                    meetings.poll();
                }

                meetings.add(m);
            }
        }

        return meetings.size();
    }
}
