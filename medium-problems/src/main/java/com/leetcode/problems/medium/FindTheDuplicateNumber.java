package com.leetcode.problems.medium;

public final class FindTheDuplicateNumber {
    // o(n) solution uses the cycle detection logic.
    // repeating number creates a cycle for ptr = num[ptr] iteration logic.
    public int findDuplicate(int[] nums) {
        int lo=1, hi=nums.length-1;

        int dup=-1;
        while(lo <= hi) {
            int cur = lo + (hi-lo)/2;

            int cnt=0;
            for(int num : nums) {
                if(num <= cur) {
                    cnt++;
                }
            }

            if(cnt > cur) {
                dup = cur;
                hi = cur-1;
            } else {
                lo = cur+1;
            }
        }
        return dup;
    }
}
