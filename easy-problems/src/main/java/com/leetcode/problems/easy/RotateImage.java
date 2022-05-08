package com.leetcode.problems.easy;

public final class RotateImage {
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private static void transpose(int[][] matrix) {
        for(int row=0;row<matrix.length;row++) {
            for(int col=row+1;col<matrix.length;col++) {
                if(row == col) {
                    continue;
                }
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private static void reverse(int[][] matrix) {
        for(int row=0;row<matrix.length;row++) {
            for(int col=0;col<matrix.length/2;col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length-1-col];
                matrix[row][matrix.length-1-col] = temp;
            }
        }
    }
}
