package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public final class BasicCalculatorV2 {
    public int calculate(String s) {
        Set<Character> ops = Set.of('+', '-', '*', '/');

        Deque<Integer> operands = new ArrayDeque<>();

        char operator = '\0';
        int num=0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + Character.digit(c, 10);
            }

            if(ops.contains(c) || i == s.length()-1) {
                if(operator == '*') {
                    operands.push(operands.pop() * num);
                } else if(operator == '/') {
                    operands.push(operands.pop() / num);
                } else if(operator == '-') {
                    operands.push(-1 * num);
                } else {
                    operands.push(num);
                }
                operator = c;
                num = 0;
            }
        }

        int sum = 0;
        while(! operands.isEmpty()) {
            sum += operands.pop();
        }
        return sum;
    }
}
