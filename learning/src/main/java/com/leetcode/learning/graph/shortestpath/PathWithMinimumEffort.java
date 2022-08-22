package com.leetcode.learning.graph.shortestpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class PathWithMinimumEffort {
    // modified dijkstra
    public int minimumEffortPath(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;

        final int[][] dirs = new int[][]{ {-1,0}, {1,0}, {0,-1}, {0,1} };

        PriorityQueue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(c -> c.effort));

        // effort to reach given cell
        int[][] efforts = new int[m][n];
        for(int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        efforts[0][0]=0;
        q.add(new Cell(0,0,0));

        while(! q.isEmpty()) {
            Cell curr = q.poll();

            // we processed this cell before and already updated efforts
            if(curr.effort > efforts[curr.row][curr.col]) {
                continue;
            }

            // reached our destination
            if(curr.row==m-1 && curr.col==n-1) {
                return curr.effort;
            }

            // check adj cells and update their effort
            for(int[] dir : dirs) {
                int row=curr.row+dir[0], col=curr.col+dir[1];

                if(row>=0 && row<m && col>=0 && col<n) {
                    // either effort on current or effort on this cell is the max for this path
                    int effort=Math.abs(heights[row][col]-heights[curr.row][curr.col]);
                    int max = Integer.max(curr.effort, effort);
                    if(max < efforts[row][col]) {
                        efforts[row][col]=max;
                        q.offer(new Cell(row, col, max));
                    }
                }
            }
        }

        return 0;
    }

    private static final class Cell {
        private final int row;
        private final int col;
        private int effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
}
