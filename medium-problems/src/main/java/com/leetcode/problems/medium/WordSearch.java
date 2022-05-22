package com.leetcode.problems.medium;

public final class WordSearch {
    private char[][] board;
    private boolean[][] visited;
    private String word;
    private int m, n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];

        for(int row=0; row < m; row++) {
            for(int col=0; col < n; col++) {
                if(check(row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int row, int col, int pos) {
        if(pos >= word.length()) {
            return true;
        }

        if(row < 0 || col < 0 || row > m-1 || col > n-1) {
            return false;
        }

        if(visited[row][col]) {
            return false;
        }

        if(board[row][col] != word.charAt(pos)) {
            return false;
        }

        visited[row][col] = true;
        boolean exist = check(row-1, col, pos+1) || check(row+1, col, pos+1)
                || check(row, col-1, pos+1) || check(row, col+1, pos+1);
        if(exist) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}
