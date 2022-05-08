package com.leetcode.problems.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public final class IsValidParentheses {
    public static boolean check(String s) {
        if(s.length() == 0) {
            return true;
        }

        if(s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i < s.length(); i++) {
            char c = s.charAt(i);
            if(pairs.containsKey(c)) {
                if(pairs.get(c) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
