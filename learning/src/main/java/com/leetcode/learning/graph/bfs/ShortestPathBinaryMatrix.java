package com.leetcode.learning.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public final class ShortestPathBinaryMatrix {
    private static final int[] dirs = new int[]{-1,0,1};

    public static int find(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        if(grid[0][0] != 0 || grid[m-1][n-1] != 0) {
            return -1;
        }

        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(! bfs.isEmpty()) {
            int[] cell = bfs.poll();
            if(cell[0] == m-1 && cell[1] == n-1) {
                return cell[2];
            }

            for(int rd : dirs) {
                for(int cd : dirs) {
                    if(rd==0 && cd==0) {
                        continue;
                    }

                    int row = cell[0] + rd;
                    int col = cell[1] + cd;

                    if(row>=0 && row < m && col >=0 && col < n
                            && grid[row][col]==0
                            && !visited[row][col]) {

                        visited[row][col] = true;
                        bfs.offer(new int[]{row,col,cell[2]+1});
                    }
                }
            }
        }

        return -1;
    }
}
