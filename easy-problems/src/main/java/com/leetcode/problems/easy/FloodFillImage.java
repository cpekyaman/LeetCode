package com.leetcode.problems.easy;

public final class FloodFillImage {
    public static int[][] fill(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc] != newColor) {
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private static void fill(int[][] image, int row, int col, int oldColor, int newColor) {
        if(image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        if(row < image.length - 1) {
            fill(image,row+1,col,oldColor,newColor);
        }
        if(row > 0) {
            fill(image,row-1,col,oldColor,newColor);
        }
        if(col < image[0].length - 1) {
            fill(image,row,col+1,oldColor,newColor);
        }
        if(col > 0) {
            fill(image,row,col-1,oldColor,newColor);
        }
    }

}
