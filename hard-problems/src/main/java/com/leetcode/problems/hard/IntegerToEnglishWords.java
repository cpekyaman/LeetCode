package com.leetcode.problems.hard;

import java.util.LinkedList;
import java.util.List;

public class IntegerToEnglishWords {
    private static final List<String> digits = List.of("", "One", "Two", "Three", "Four",
                                                       "Five", "Six", "Seven", "Eight", "Nine");

    private static final List<String> tens = List.of("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                                                     "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen");

    private static final List<String> doubleDigits = List.of("Ten", "Twenty", "Thirty", "Forty", "Fifty",
                                                             "Sixty", "Seventy", "Eighty", "Ninety");

    private static final List<String> groups = List.of("", "Thousand", "Million", "Billion");

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }

        int group = 0;

        // we parse num in the groups of three digits.
        // because three digits are parsed the same way.
        // the only difference is they have multiplier / suffix for thousands etc.
        LinkedList<String> ans = new LinkedList<>();
        while(num > 0) {
            int rem = num % 1000;
            // if we have a numberlike 1_000_000, second and last groups are not really parsed.
            // as the number is simply "One Million".
            if(rem != 0) {
                ans.addFirst(toString3Digit(rem, groups.get(group)));
            }

            group++;
            num /= 1000;
        }

        return String.join(" ", ans);
    }

    private String toString3Digit(int num, String group) {
        LinkedList<String> ans = new LinkedList<>();

        // add the hundreth
        if(num >= 100) {
            ans.add(digits.get(num/100) + " Hundred");
            num = num % 100;
        }

        // we have three cases: 0<10, 10<20,20<100.
        if(num >= 20) {
            // number can be 20 or 25, first case has num%10 as 0.
            ans.add(doubleDigits.get(num/10 - 1));
            if(num % 10 != 0) {
                ans.add(digits.get(num%10));
            }
        } else if(num >= 10) {
            ans.add(tens.get(num%10));
        } else if(num > 0) {
            ans.add(digits.get(num));
        }

        // add the group specifier
        if(group.length() > 0) {
            ans.add(group);
        }

        return String.join(" ", ans);
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(123));
        System.out.println(new IntegerToEnglishWords().numberToWords(5123));
        System.out.println(new IntegerToEnglishWords().numberToWords(1234567));
        System.out.println(new IntegerToEnglishWords().numberToWords(10));
        System.out.println(new IntegerToEnglishWords().numberToWords(35));
        System.out.println(new IntegerToEnglishWords().numberToWords(1000));
        System.out.println(new IntegerToEnglishWords().numberToWords(1_000_000_000));
        System.out.println(new IntegerToEnglishWords().numberToWords(1_005_010_004));
        System.out.println(new IntegerToEnglishWords().numberToWords(100));
    }
}
