package com.leetcode.problems.easy;

public final class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length <= 1) {
            return true;
        }

        int[] charOrder = new int[order.length()];
        for(int i=0; i < order.length(); i++) {
            charOrder[order.charAt(i)-'a'] = i;
        }

        for(int i=0;i<words.length-1;i++) {
            String left = words[i];
            String right = words[i+1];

            int len = Integer.min(left.length(), right.length());
            int matchCount=0;
            for(int j=0;j<len;j++) {
                if(left.charAt(j) == right.charAt(j)) {
                    matchCount++;
                } else if(charOrder[left.charAt(j)-'a'] < charOrder[right.charAt(j)-'a']) {
                    break;
                } else {
                    return false;
                }
            }

            if(matchCount == len && left.length() > right.length()) {
                return false;
            }
        }

        return true;
    }
}
