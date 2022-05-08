package com.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

public final class ValidSudoku {
    public static boolean validate(char[][] board) {
        int N = board.length;

        Set<Character> rowVals = new HashSet<>(N);

        Set<Character>[] colVals = new Set[N];
        Set<Character>[] boxVals = new Set[N];

        for(int row = 0; row < N; row++) {
            rowVals.clear();
            for(int col = 0; col < N; col++) {
                char c = board[row][col];
                if(c == '.') {
                    continue;
                }

                if(rowVals.contains(c)) {
                    return false;
                }
                rowVals.add(c);

                if(colVals[col] == null) {
                    colVals[col] = new HashSet<>(N);
                }
                if(colVals[col].contains(c)) {
                    return false;
                }
                colVals[col].add(c);

                int box = (row / 3) * 3 + (col / 3);
                if(boxVals[box] == null) {
                    boxVals[box] = new HashSet<>(N);
                }
                if(boxVals[box].contains(c)) {
                    return false;
                }
                boxVals[box].add(c);
            }
        }

        return true;
    }
}
