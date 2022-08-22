package com.leetcode.problems.hard;

public final class LongestIncreasingPathInMatrix {
    private static final int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        int[][] memo = new int[matrix.length][matrix[0].length];

        for(int row=0; row<matrix.length; row++) {
            for(int col=0; col<matrix[0].length; col++) {
                ans = Integer.max(ans, dfs(matrix, row, col, memo));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if(memo[row][col] != 0) {
            return memo[row][col];
        }

        int ans = 0;
        for(int[] dir : dirs) {
            int nr=row+dir[0], nc=col+dir[1];
            if(nr>=0 && nr<matrix.length && nc>=0 && nc<matrix[0].length
                    && matrix[nr][nc] > matrix[row][col]) {
                ans = Integer.max(ans, dfs(matrix, nr, nc, memo));
            }
        }
        memo[row][col] = ans+1;
        return memo[row][col];
    }
}
