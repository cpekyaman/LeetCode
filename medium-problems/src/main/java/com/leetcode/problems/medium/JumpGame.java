package com.leetcode.problems.medium;

import java.util.Arrays;

public final class JumpGame {
    public boolean bottomUp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[dp.length-1] = 0;

        for(int i=nums.length-2; i>=0; i--) {
            int maxJump = Math.min(i+nums[i], nums.length-1);
            for(int j=i+1; j<=maxJump; j++) {
                if(dp[j] == 0) {
                    dp[i] = 0;
                    break;
                }
            }
        }

        return dp[0] == 0;
    }

    public boolean topDown(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        memo[memo.length-1] = 0;

        return canJumpFromIndex(nums, memo, 0);
    }

    private boolean canJumpFromIndex(int[] nums, int[] memo, int index) {
        if(memo[index] != -1) {
            return memo[index] == 0;
        }

        int maxJump = Math.min(index + nums[index], nums.length-1);
        for(int i=index+1; i<=maxJump; i++) {
            if(canJumpFromIndex(nums, memo, i)) {
                memo[index] = 0;
                return true;
            }
        }
        memo[index] = 1;
        return false;
    }
}
