package com.leetcode.problems.medium;

public final class StringToInteger {
    public static int atoi(String s) {
        int n = s.length();
        if(n == 0) {
            return 0;
        }

        int i = 0;
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        int mul = 1;
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if(s.charAt(i) == '-') {
                mul = -1;
            }
            i++;
        }

        int result=0;
        while(i < n && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));

            if(mul == 1 && (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && digit > 7))) {
                return Integer.MAX_VALUE;
            }
            if(mul == -1 && (result * mul < Integer.MIN_VALUE / 10
                    || (result * mul == Integer.MIN_VALUE / 10 && digit > 8))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        result *= mul;
        return result;
    }
}
