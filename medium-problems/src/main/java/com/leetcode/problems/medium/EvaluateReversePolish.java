package com.leetcode.problems.medium;

import java.util.Deque;
import java.util.LinkedList;

public final class EvaluateReversePolish {
    public static int eval(String[] tokens) {
        Deque<Integer> operands = new LinkedList<>();
        for(String token : tokens) {
            if("+".equals(token)) {
                operands.push(operands.pop() + operands.pop());
            } else if("-".equals(token)) {
                int b = operands.pop();
                int a = operands.pop();
                operands.push(a-b);
            } else if("*".equals(token)) {
                operands.push(operands.pop() * operands.pop());
            } else if("/".equals(token)) {
                int b = operands.pop();
                int a = operands.pop();
                operands.push(a/b);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }
}
