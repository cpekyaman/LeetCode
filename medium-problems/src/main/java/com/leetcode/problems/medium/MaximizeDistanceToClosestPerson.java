package com.leetcode.problems.medium;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        final int n = seats.length;
        int lastOccupied=-1, max=0;

        // we count the sequence of zeroes (longest empty seats between two people).
        // the max distance is the middle of current sequence of zeroes.
        // the exceptions are at the start and end, as they have one side free.
        for(int i=0; i<n; i++) {
            if(seats[i] == 1) {
                max = lastOccupied < 0 ? i : Integer.max(max, (i-lastOccupied)/2);
                lastOccupied=i;
            }
        }

        // don't forget the check from last occupied to end
        max = Integer.max(max, n-lastOccupied-1);

        return max;
    }
}
