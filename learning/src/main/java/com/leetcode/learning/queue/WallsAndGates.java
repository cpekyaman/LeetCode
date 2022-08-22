package com.leetcode.learning.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public final class WallsAndGates {
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
    private static final int EMPTY = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        final int m = rooms.length;
        final int n = rooms[0].length;

        Queue<int[]> bfs = new ArrayDeque<>();
        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(rooms[row][col] == 0) {
                    bfs.offer(new int[]{row, col});
                }
            }
        }

        while(! bfs.isEmpty()) {
            int[] cell = bfs.poll();

            for(int[] xy : dirs) {
                int row = cell[0]+xy[0], col = cell[1]+xy[1];
                if(row < m && row >= 0 && col < n && col >= 0 && rooms[row][col] == EMPTY) {
                    rooms[row][col] = rooms[cell[0]][cell[1]] + 1;
                    bfs.offer(new int[]{row, col});
                }
            }
        }
    }
}
