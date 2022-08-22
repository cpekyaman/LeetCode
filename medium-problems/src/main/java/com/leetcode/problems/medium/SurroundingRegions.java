package com.leetcode.problems.medium;

import java.util.*;

public class SurroundingRegions {
    private static final int[][] dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};

    public void solve(char[][] board) {

        List<int[]> borderCells = new LinkedList<>();

        // find the cells at the left and right borders
        for(int row=0; row<board.length; row++) {
            borderCells.add(new int[]{row, 0});
            if(board[0].length > 1) {
                borderCells.add(new int[]{row, board[0].length-1});
            }
        }

        // find the cells at the top and bottom borders
        for(int col=0; col<board[0].length; col++) {
            borderCells.add(new int[]{0, col});
            if(board.length > 1) {
                borderCells.add(new int[]{board.length-1, col});
            }
        }

        // mark the neighbors of each border cell
        for(int[] cell : borderCells) {
            if(board[cell[0]][cell[1]] == 'O') {
                mark(board, cell);
            }
        }

        // capture surrounded cells not marked as border.
        // reset the cells marked as border to their original value.
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(board[row][col] == 'O') {
                    board[row][col]='X';
                } else if(board[row][col]=='A') {
                    board[row][col]='O';
                }
            }
        }
    }

    private void mark(char[][] board, int[] cell) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(cell);

        while(! q.isEmpty()) {
            int[] curr = q.poll();
            if(board[curr[0]][curr[1]] != 'O') {
                continue;
            }

            board[curr[0]][curr[1]] = 'A';

            for(int[] dir : dirs) {
                int nr=curr[0]+dir[0];
                int nc=curr[1]+dir[1];

                if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O') {
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
