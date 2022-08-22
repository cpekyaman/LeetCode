package com.leetcode.learning.heap;

import java.util.PriorityQueue;

public final class FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> climbs = new PriorityQueue<>();

        int b=bricks, l=ladders, i=0;
        for(;i<heights.length-1; i++) {
            int diff = heights[i+1]-heights[i];
            if(diff <= 0) {
                continue;
            }

            if(l > 0) {
                climbs.add(diff);
                l--;
                continue;
            }

            if(! climbs.isEmpty() && diff > climbs.peek() && b >= climbs.peek()) {
                b-=climbs.poll();
                climbs.add(diff);
            } else if(b >= diff) {
                b-=diff;
            } else {
                return i;
            }
        }
        return heights.length-1;
    }
}
