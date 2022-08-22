package com.leetcode.learning.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public final class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{ {-1,0}, {1,0}, {0,-1}, {0,1} };

        List<int[]> rotten = new ArrayList<>();
        int fresh = findRottenAndFresh(grid, rotten);

        int minutes = 0;
        // we use / rotate the list of rotten at each minute.
        // and continue to rot new ones to be the next rotten list.
        // we can also use a queue with sentinel items to mark minute changes.
        while(! rotten.isEmpty()) {
            List<int[]> previousRotten = rotten;
            rotten = new ArrayList<>();

            for(int[] rot : previousRotten) {
                for(int[] dir : dirs) {
                    int row = rot[0] + dir[0];
                    int col = rot[1] + dir[1];

                    if(row >= 0 && row < grid.length
                            && col >= 0 && col < grid[0].length
                            && grid[row][col]==1) {
                        grid[row][col]=2;
                        rotten.add(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            minutes++;
        }

        if(fresh > 0) {
            return -1;
        }

        // we didn't even enter the loop if minutes is zero.
        // we terminate loop when rotten is empty.
        // that means in the last pass nothing became rotten.
        return minutes > 0 ? minutes-1 : 0;
    }

    private int findRottenAndFresh(int[][] grid, List<int[]> rotten) {
        int fresh=0;
        for(int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                if(grid[row][col] == 2) {
                    rotten.add(new int[]{row, col});
                } else if(grid[row][col] == 1) {
                    fresh++;
                }
            }
        }
        return fresh;
    }
}
