package com.leetcode.problems.medium;

import java.util.Deque;
import java.util.LinkedList;

public final class DecodeString {
    public static String decode(String s) {
        Deque<Integer> kstack = new LinkedList<>();
        Deque<StringBuilder> strstack = new LinkedList<>();

        StringBuilder decoded = new StringBuilder();

        int k=0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = k * 10 + Character.digit(c, 10);
            } else if(c == '[') {
                kstack.push(k);
                strstack.push(decoded);
                decoded = new StringBuilder();
                k=0;
            } else if(c == ']') {
                StringBuilder current = strstack.pop();
                for(int i=kstack.pop(); i>0; i--) {
                    current.append(decoded);
                }
                decoded = current;
            } else {
                decoded.append(c);
            }
        }

        return decoded.toString();
    }

    public static void main(String[] args) {
        System.out.println(DecodeString.decode("3[a]2[bc]"));
    }
}
