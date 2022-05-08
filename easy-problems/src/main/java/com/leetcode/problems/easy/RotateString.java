package com.leetcode.problems.easy;

public final class RotateString {
    public static boolean check(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        int ps=0;
        StringBuilder prefix = new StringBuilder();
        while(ps < s.length()) {
            while(ps < s.length() && s.charAt(ps) != goal.charAt(0)) {
                prefix.append(s.charAt(ps));
                ps++;
            }

            if(goal.equals(s.substring(ps) + prefix)) {
                return true;
            }

            if(ps < s.length()) {
                prefix.append(s.charAt(ps));
            }
            ps++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(RotateString.check("ckahkzpikz", "hkzpikzcka"));
    }
}
