package com.leetcode.problems.easy;

public final class ExcelColumnTitle {
    public static String convert(int columnNumber) {
        StringBuilder title = new StringBuilder();
        int num = columnNumber;
        while(num > 0) {
            char letter = (char) ('A' + (num-1) % 26);
            num = (num - 1) / 26;
            title.append(letter);
        }

        return title.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(ExcelColumnTitle.convert(701));
    }
}
