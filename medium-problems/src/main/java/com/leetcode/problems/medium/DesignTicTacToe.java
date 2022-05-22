package com.leetcode.problems.medium;

public final class DesignTicTacToe {
    public static final class TicTacToe {
        private final int[][] board;
        private final int[] rowCounter;
        private final int[] colCounter;

        private int diagCounter;
        private int antiDiagCounter;
        private final int n;

        public TicTacToe(int n) {
            this.n = n;
            this.board = new int[n][n];
            this.rowCounter = new int[n];
            this.colCounter = new int[n];
        }

        public int move(int row, int col, int player) {
            int p = player == 1 ? 1 : -1;

            if(board[row][col] == 0) {
                board[row][col] = p;

                rowCounter[row] += p;
                colCounter[col] += p;

                if(row == col) {
                    diagCounter += p;
                }
                if(row+col == n-1) {
                    antiDiagCounter += p;
                }
            }

            if(Math.abs(antiDiagCounter)==n || Math.abs(diagCounter)==n
                    || Math.abs(rowCounter[row]) == n || Math.abs(colCounter[col])==n) {
                return player;
            }
            return 0;
        }
    }
}
