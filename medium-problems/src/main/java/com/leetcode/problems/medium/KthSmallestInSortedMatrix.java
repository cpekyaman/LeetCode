package com.leetcode.problems.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class KthSmallestInSortedMatrix {
    public static int find(int[][] matrix, int k) {
        PriorityQueue<Cell> cells = new PriorityQueue<>(Comparator.comparingInt(c -> matrix[c.row][c.col]));

        final int m = matrix.length;
        final int n = matrix[0].length;

        for(int i=0; i<m && i<k; i++) {
            cells.add(new Cell(i, 0));
        }

        int count=0;
        int result=0;
        while(! cells.isEmpty()) {
            Cell current = cells.poll();
            if(++count==k) {
                result = matrix[current.row][current.col];
                break;
            }
            if(current.col < n-1) {
                cells.add(current.nextCol());
            }
        }
        return result;
    }

    private static final class Cell {
        private int row;
        private int col;

        Cell(int r, int c) {
            this.row = r;
            this.col = c;
        }

        Cell nextCol() {
            this.col++;
            return this;
        }
    }
}
