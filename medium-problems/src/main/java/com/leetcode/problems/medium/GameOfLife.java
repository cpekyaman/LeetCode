package com.leetcode.problems.medium;

public final class GameOfLife {
    public void play(int[][] board) {
        final int m= board.length;
        final int n= board[0].length;

        int[][] neighbors = new int[][]{ {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0} };

        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                int live=0;
                for(int[] nb : neighbors) {
                    if(row+nb[1] >=0 && row+nb[1] < m && col+nb[0] >=0 && col+nb[0] < n) {
                        live += Math.abs(board[row+nb[1]][col+nb[0]]) == 1 ? 1 : 0;
                    }
                }

                if(board[row][col] == 0) {
                    if(live == 3) {
                        board[row][col] = 2;
                    }
                } else if(live < 2 || live > 3)  {
                    board[row][col] = -1;
                }
            }
        }

        for(int row=0; row<m; row++) {
            for(int col=0; col<n; col++) {
                if(board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
