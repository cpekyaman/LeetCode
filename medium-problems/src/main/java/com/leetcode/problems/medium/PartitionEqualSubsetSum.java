package com.leetcode.problems.medium;

public final class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        return topDown(nums);
    }

    public boolean topDown(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) {
            return false;
        }

        int targetSum = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][targetSum+1];
        return topDownRecursive(nums, targetSum, 0, memo);
    }

    private boolean topDownRecursive(int[] nums, int targetSum, int index, Boolean[][] memo) {
        if(targetSum == 0) {
            return true;
        }

        if(index >= nums.length || targetSum < 0) {
            return false;
        }

        if(memo[index][targetSum] == null) {
            memo[index][targetSum] = topDownRecursive(nums, targetSum-nums[index], index+1, memo)
                    || topDownRecursive(nums, targetSum, index+1, memo);
        }

        return memo[index][targetSum];
    }

    public boolean bottomUp(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        boolean[][] dp = new boolean[nums.length+1][targetSum+1];
        dp[0][0] = true;

        for(int i=1; i<dp.length; i++) {
            for(int sum=0; sum<=targetSum; sum++) {
                if(sum < nums[i-1]) {
                    dp[i][sum] = dp[i-1][sum];
                } else {
                    dp[i][sum] = dp[i-1][sum] || dp[i-1][sum-nums[i-1]];
                }
            }
        }

        return dp[nums.length][targetSum];
    }

    public boolean optimizedBottomUp(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum+1];
        dp[0] = true;

        for(int num : nums) {
            for(int sum=targetSum; sum >= num; sum--) {
                dp[sum] |= dp[sum-num];
            }
        }

        return dp[targetSum];
    }
}
