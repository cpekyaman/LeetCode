package com.leetcode.problems.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public final class BasicCalculator {
    public static int calculate(String s) {
        Set<Character> operators = Set.of('+', '-');

        int sign = 1, operand=0, lastResult = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // build current operand
            if (Character.isDigit(c)) {
                operand = operand * 10 + Character.digit(c, 10);
            }
            // add current operand to result with the last operator sign.
            // then reset the sign and operand.
            else if (operators.contains(c)) {
                lastResult += operand * sign;
                operand = 0;
                if(c == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
            }
            // add running sum and last operator sign to stack.
            // last operator sign will be applied as multiplier to result between parens.
            else if (c == '(') {
                stack.push(lastResult);
                stack.push(sign);

                lastResult = 0;
                sign = 1;
            }
            // apply the sign before '(' to the current result.
            // and add the result before '(' to the result between parens.
            else if (c == ')') {
                lastResult = (lastResult + (operand * sign)) * stack.pop() + stack.pop();
                operand = 0;
            }
        }

        // last element can be an operand
        return lastResult + (operand * sign);
    }

    public static void main(String[] args) {
        System.out.println(BasicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(BasicCalculator.calculate("- (3 + (4 + 5))"));
    }
}
