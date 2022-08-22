package com.leetcode.problems.hard;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        // since our formula is nums[i - 1] * nums[i] * nums[i + 1],
        // we add two sentinel values at each end of the array to simplify logic.
        final int n = nums.length+2;
        int[] balloons = new int[n];
        System.arraycopy(nums, 0, balloons, 1, nums.length);
        balloons[0]=1;
        balloons[n-1]=1;

        int[][] memo = new int[n][n];
        return maxCoins(balloons, memo, 1, n-2);
    }

    private int maxCoins(int[] balloons, int[][] memo, int left, int right) {
        if(left > right) {
            return 0;
        }

        if(memo[left][right] > 0) {
            return memo[left][right];
        }

        int coins=0;
        for(int i=left; i<=right; i++) {
            // ith balloon is always burst after its left and right.
            // so, it uses left-1 and right+1 as its neighbors.
            int coin = balloons[left-1] * balloons[i] * balloons[right+1];

            int coinsLeft = maxCoins(balloons, memo, left, i-1);
            int coinsRight = maxCoins(balloons, memo, i+1, right);

            coins = Integer.max(coins, coin + coinsLeft + coinsRight);
        }

        memo[left][right]=coins;
        return coins;
    }
}
