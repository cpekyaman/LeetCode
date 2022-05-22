package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public final class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int a : asteroids) {
            boolean push = true;
            if(a < 0) {
                while(! stack.isEmpty() && stack.peek() > 0) {
                    Integer a2 = stack.peek();
                    if(a2 >= -a) {
                        push = false;
                        if(a2 == -a) {
                            stack.pop();
                        }
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(push) {
                stack.push(a);
            }
        }

        int[] ans = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
