package com.leetcode.problems.medium;

import java.util.List;
import java.util.Map;

public final class IntegerToRoman {
    // a slow logic without tabulating combinations like XC, IX etc. separately
    public static String convert(int num) {
        StringBuilder roman = new StringBuilder();

        // per each 10th digit position we have almost the same structure.
        // one base, one middle and one 10th symbol.
        Map<Integer, List<String>> symbols = Map.of(1, List.of("I", "V", "X"),
                                                    10, List.of("X", "L", "C"),
                                                    100, List.of("C", "D", "M"),
                                                    1000, List.of("M"));

        // find the most significant digit position
        int div=1, n=num;
        while(n >= 10) {
            n /= 10;
            div *= 10;
        }

        // for each most significant digit combine symbols for current 10th position.
        // shift the number to left, reduce the 10th position and repeat.
        while(num > 0) {
            int rem = num / div;
            List<String> s = symbols.get(div);

            if(rem == 9) {
                roman.append(s.get(0)).append(s.get(2));
            } else if(rem >= 5) {
                roman.append(s.get(1));
                for(int i=0; i<rem-5; i++) {
                    roman.append(s.get(0));
                }
            } else if(rem == 4) {
                roman.append(s.get(0)).append(s.get(1));
            } else {
                for(int i=0; i<rem; i++) {
                    roman.append(s.get(0));
                }
            }

            num = num % div;
            div /= 10;
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(IntegerToRoman.convert(3));
        System.out.println(IntegerToRoman.convert(58));
        System.out.println(IntegerToRoman.convert(1994));
    }
}
