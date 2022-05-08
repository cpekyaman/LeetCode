package com.leetcode.problems.easy;

public final class IslandPerimeter {
    public static int find(int[][] grid){
        final int m = grid.length;
        final int n = grid[0].length;

        int perimeter=0;
        for(int row=0; row < m; row++) {
            for(int col=0; col < n; col++) {
                if(grid[row][col] == 1) {
                    if(row == 0 || grid[row-1][col]==0) {
                        perimeter++;
                    }
                    if(col == n-1 || grid[row][col+1]==0){
                        perimeter++;
                    }
                    if(row == m-1 || grid[row+1][col] == 0) {
                        perimeter++;
                    }
                    if(col == 0 || grid[row][col-1]==0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }
}
