package com.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public final class BaseballGame {
    public static int play(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String op : ops) {
            if(op.equals("+")) {
                int prev = stack.pop();
                int next = stack.peek() + prev;
                stack.push(prev);
                stack.push(next);
            } else if(op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if(op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int ans = 0;
        while(! stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(BaseballGame.play(new String[]{"5","2","C","D","+"}));
    }
}
