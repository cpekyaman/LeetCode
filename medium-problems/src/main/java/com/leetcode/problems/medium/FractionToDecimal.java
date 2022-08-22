package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public final class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }

        StringBuilder fraction = new StringBuilder();
        if(Integer.signum(numerator) != Integer.signum(denominator)) {
            fraction.append('-');
        }

        // taking abs of both to make the job easier.
        // long conversion is to prevent overflow as MIN_VALUE is in range.
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        // there is no fraction
        if(remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");

        Map<Long, Integer> remainderIndex = new HashMap<>();
        while(remainder != 0) {
            if(remainderIndex.containsKey(remainder)) {
                fraction.insert(remainderIndex.get(remainder), "(");
                fraction.append(')');
                break;
            }

            // remember the position of the initial/previous remainder.
            // when remainder starts repeating, so does the fraction.
            remainderIndex.put(remainder, fraction.length());

            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder = remainder % divisor;
        }
        return fraction.toString();
    }
}
