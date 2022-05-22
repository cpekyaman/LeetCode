package com.leetcode.problems.medium;

import java.util.Deque;
import java.util.LinkedList;

public final class ReverseWordsInAString {
    public String reverseWords(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder current = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isWhitespace(c)) {
                if(current.length() != 0) {
                    stack.push(current.toString());
                    current = new StringBuilder();
                }
            } else {
                current.append(c);
            }
        }

        if(current.length() != 0) {
            stack.push(current.toString());
        }

        StringBuilder result = new StringBuilder();
        while(! stack.isEmpty()) {
            if(result.length() > 0) {
                result.append(" ");
            }
            result.append(stack.pop());
        }
        return result.toString();
    }
}
