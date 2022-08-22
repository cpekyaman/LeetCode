package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public final class ShortestBridge {
    private static final int[][] dirs = new int [][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static int shortestBridge(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        // we first mark one of the islands in the grid.

        Queue<int[]> islandEdges = new ArrayDeque<>();
        boolean marked=false;
        for(int row=0; row<m; row++) {
            if(marked) {
                break;
            }

            for(int col=0; col<n; col++) {
                if(grid[row][col]==1) {
                    marked=true;
                    grid[row][col]=2;
                    markIsland(grid, islandEdges, row, col);
                    break;
                }
            }
        }

        // then we expand from the island to the next one in bfs manner.
        int ans=0;
        while(! islandEdges.isEmpty()) {
            int sz = islandEdges.size();

            for(int i=0; i<sz; i++) {
                int[] cell = islandEdges.poll();

                for(int[] dir : dirs) {
                    int row=cell[0] + dir[0];
                    int col=cell[1] + dir[1];

                    if(row>=0 && row<m && col>=0 && col<n) {
                        if(grid[row][col]==1) {
                            return ans;
                        } else if(grid[row][col]==0) {
                            grid[row][col]=2;
                            islandEdges.offer(new int[]{row, col});
                        }
                    }
                }
            }
            ans++;
        }

        return ans;
    }

    private static void markIsland(int[][] grid, Queue<int[]> islandEdges, int row, int col) {
        final int m = grid.length;
        final int n = grid[0].length;

        Queue<int[]> cells = new ArrayDeque<>();
        cells.offer(new int[]{row, col});

        while(! cells.isEmpty()) {
            int[] cell = cells.poll();

            boolean edgeFound=false;
            for(int[] dir : dirs) {
                int rnext=cell[0] + dir[0];
                int cnext=cell[1] + dir[1];

                if(rnext>=0 && rnext<m && cnext>=0 && cnext<n) {
                    // we expand the island with new cell.
                    // if the next cell is water, we add the current cell as edge of island.
                    if(grid[rnext][cnext]==1) {
                        grid[rnext][cnext]=2;
                        cells.offer(new int[]{rnext, cnext});
                    } else if(grid[rnext][cnext]==0 && !edgeFound) {
                        edgeFound=true;
                        islandEdges.offer(cell);
                    }
                }
            }
        }
    }
}
