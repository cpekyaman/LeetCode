package com.leetcode.problems.medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class MinRemoveToMakeParensValid {
    public String build(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }

        Deque<Integer> openParenPos = new LinkedList<>();
        Set<Integer> toBeRemoved = new HashSet<>();
        for(int i= 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(openParenPos.isEmpty()) {
                    toBeRemoved.add(i);
                } else {
                    openParenPos.pop();
                }
            } else if(c == '(') {
                openParenPos.push(i);
            }
        }

        toBeRemoved.addAll(openParenPos);

        StringBuilder ans = new StringBuilder();
        for(int i= 0; i<s.length(); i++) {
            if(! toBeRemoved.contains(i)) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
