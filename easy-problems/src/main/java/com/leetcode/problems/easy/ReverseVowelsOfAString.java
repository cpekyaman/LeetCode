package com.leetcode.problems.easy;

import java.util.Set;

public final class ReverseVowelsOfAString {
    public static String reverse(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }

        int left = 0;
        int right = s.length()-1;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] chars = s.toCharArray();
        while(left < right) {
            while(! vowels.contains(chars[left]) && left < right) {
                left++;
            }
            while(! vowels.contains(chars[right]) && right > left) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
