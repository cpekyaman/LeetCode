package com.leetcode.problems.medium;

public final class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);

        StringBuilder ans = new StringBuilder();
        int count=1;
        char last=s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != last) {
                ans.append(count).append(last);
                last = s.charAt(i);
                count=1;
            } else {
                count++;
            }
        }
        ans.append(count).append(last);

        return ans.toString();
    }
}
