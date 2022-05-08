package com.leetcode.problems.easy;

public final class TicTacToeWinner {
    public static String play(int[][] moves) {
        final int boardSize = 3;

        int[] rows = new int[boardSize];
        int[] cols = new int[boardSize];
        int diag = 0, antiDiag=0;

        String result = moves.length < boardSize*boardSize ? "Pending" : "Draw";

        int player = 1;
        for(int[] move : moves) {
            int row = move[0], col = move[1];

            rows[row] += player;
            cols[col] += player;

            if(row == col) {
                diag += player;
            }
            if(row + col == boardSize - 1) {
                antiDiag += player;
            }

            if(Math.abs(rows[row]) == boardSize || Math.abs(cols[col]) == boardSize
                    || Math.abs(diag) == boardSize || Math.abs(antiDiag) == boardSize) {
                result = player == 1 ? "A" : "B";
                break;
            }
            player *= -1;
        }

        return result;
    }
}
