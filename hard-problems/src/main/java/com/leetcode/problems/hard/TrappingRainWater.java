package com.leetcode.problems.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public final class TrappingRainWater {
    public int trap(int[] height) {
        // monotonic stack
        Deque<Integer> stack = new ArrayDeque<>();

        int total=0, current=0;
        // adding current index while height[curr] < previous.
        // as soon as we found a height[curr] > previous, we can hold water.
        // we pop the potential tap positions and process them.
        while(current < height.length) {
            while(!stack.isEmpty() && height[current] > height[stack.peek()]) {
                // this is the index we tap water
                int tapHole = stack.pop();

                // there is no previous higher point to trap water within
                if(stack.isEmpty()) {
                    break;
                }

                // width of the tap is from current to height before tapHole
                int dist = current-stack.peek()-1;
                // tap height= (minimum height at bounds) - (tapHole height)
                int h = Integer.min(height[current],height[stack.peek()])-height[tapHole];
                total += dist * h;
            }
            stack.push(current++);
        }
        return total;
    }
}
