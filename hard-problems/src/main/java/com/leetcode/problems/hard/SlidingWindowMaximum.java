package com.leetcode.problems.hard;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> window = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];

        int maxIdx=0;
        for(int i=0; i<nums.length; i++) {
            // this is the sliding window part
            if(! window.isEmpty() && window.peekFirst() == i-k) {
                window.removeFirst();
            }

            // we are removing all nums less than the last item in the queue.
            // they cannot be the max of any window that includes the last item.
            while(! window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.removeLast();
            }

            window.addLast(i);

            // once we reach the windows size, we add new ans for each i
            if(i >= k-1) {
                // we peek the first element of the window
                ans[i-k+1]=nums[window.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SlidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(SlidingWindowMaximum.maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
