package com.leetcode.learning.queue;

import java.util.LinkedList;
import java.util.Queue;

public final class NumIslands {
    private char[][] grid;
    private int m,n,count;

    public int numIslands(char[][] grid) {
        this.count = 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == '1') {
                    count++;
                    traverseIsland(row, col);
                }
            }
        }

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == '2') {
                    grid[row][col] = '1';
                }
            }
        }

        return count;
    }

    private void traverseIsland(int row, int col) {
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(row, col));
        while(! queue.isEmpty()) {
            Cell cell = queue.poll();
            if(cell.row > 0 && grid[cell.row-1][cell.col] == '1') {
                addCell(queue, cell.row-1, cell.col);
            }
            if(cell.row < m-1 && grid[cell.row+1][cell.col] == '1') {
                addCell(queue, cell.row+1, cell.col);
            }
            if(cell.col > 0 && grid[cell.row][cell.col-1] == '1') {
                addCell(queue, cell.row, cell.col-1);
            }
            if(cell.col < n-1 && grid[cell.row][cell.col+1] == '1') {
                addCell(queue, cell.row, cell.col+1);
            }
        }
    }

    private void addCell(Queue<Cell> queue, int r, int c) {
        grid[r][c] = '2';
        queue.offer(new Cell(r,c));
    }

    private static class Cell {
        int row, col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };

        System.out.println(new NumIslands().numIslands(grid));
    }
}
