package com.leetcode.problems.easy;

import java.util.LinkedList;
import java.util.List;

public final class PlusOneArrayDigits {

    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i] == 9) {
                digits[i]=0;
            } else {
                digits[i]++;
                break;
            }
        }

        if(digits[0] != 0) {
            return digits;
        }

        int[] ans = new int[digits.length + 1];
        ans[0]=1;
        return ans;
    }

}
