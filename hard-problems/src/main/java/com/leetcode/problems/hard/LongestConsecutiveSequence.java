package com.leetcode.problems.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(int num : nums) {
            uniqueNums.add(num);
        }

        int longest=0;
        for(int num : uniqueNums) {
            if(! uniqueNums.contains(num-1)) {
                int end = num;
                while(uniqueNums.contains(end + 1)) {
                    end++;
                }
                longest = Integer.max(longest, end-num+1);
            }
        }
        return longest;
    }
}
