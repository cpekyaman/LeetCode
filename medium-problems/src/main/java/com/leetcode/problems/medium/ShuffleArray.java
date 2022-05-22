package com.leetcode.problems.medium;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public final class ShuffleArray {
    private final int[] nums;
    private final Random rand;
    private final int n;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
        this.n = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = new int[n];
        Set<Integer> indices = new LinkedHashSet<>(ans.length);
        while(indices.size() < n) {
            indices.add(rand.nextInt(n));
        }
        int i=0;
        for(Integer index : indices) {
            ans[i++] = nums[index];
        }
        return ans;
    }
}
