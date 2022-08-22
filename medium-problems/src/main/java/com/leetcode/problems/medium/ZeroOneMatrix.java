package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public final class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        final int m = mat.length;
        final int n = mat[0].length;

        int[][] dist = new int[m][n];

        Queue<int[]> bfs = new ArrayDeque<>();
        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(mat[row][col] == 0) {
                    bfs.offer(new int[]{row, col});
                } else {
                    dist[row][col] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(! bfs.isEmpty()) {
            int[] cell = bfs.poll();
            for(int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if(row >= 0 && row<m && col>=0 && col<n && mat[row][col]==1) {
                    int newDist = dist[cell[0]][cell[1]] + 1;
                    if(dist[row][col] > newDist) {
                        dist[row][col] = newDist;
                        bfs.offer(new int[]{row, col});
                    }
                }
            }
        }
        return dist;
    }
}
