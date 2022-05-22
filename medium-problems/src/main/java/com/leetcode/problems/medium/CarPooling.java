package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public final class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> Integer.compare(t1[1], t2[1]));

        PriorityQueue<int[]> active = new PriorityQueue<>((t1, t2) -> Integer.compare(t1[2], t2[2]));

        int runCap=capacity;
        for(int[] trip : trips) {
            while(! active.isEmpty() && trip[1] >= active.peek()[2]) {
                runCap += active.poll()[0];
            }

            if(runCap < trip[0]) {
                return false;
            }
            active.add(trip);
            runCap -= trip[0];
        }
        return true;
    }
}
