package com.leetcode.problems.medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        final int intMinHalfLimit = Integer.MIN_VALUE >> 1;

        // special edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // negating both numbers if necessary to work with all negatives.
        // allows considering less edge cases as we have more negative ints than positives.
        int negated=0;
        if(dividend > 0) {
            dividend = -dividend;
            negated++;
        }

        if(divisor > 0) {
            divisor = -divisor;
            negated++;
        }

        int quotient = 0;

        // for each dividend / divisor, we try to find max number of divisors to fit in current dividend.
        // we do this by exponentially expanding divisor sum.
        // once we found a multiplier, we add it to quotient, update the dividend and go on for next iteration.
        while(divisor >= dividend) {

            // multiplier is also negated because of the edge cases like MIN_VALUE / -1.
            int val = divisor, multiplier=-1;
            // the magic number -1073741824 is MIN_VALUE / 2, after which we overflow.
            while(val >= intMinHalfLimit && val + val >= dividend) {
                val += val;
                multiplier += multiplier;
            }

            quotient += multiplier;
            dividend -= val;
        }

        // if both were negative or both were positive initially, make quotient positive
        if(negated != 1) {
            return -quotient;
        }
        return quotient;
    }
}
