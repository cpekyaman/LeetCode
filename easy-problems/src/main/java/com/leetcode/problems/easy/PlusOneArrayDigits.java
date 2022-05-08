package com.leetcode.problems.easy;

import java.util.LinkedList;
import java.util.List;

public final class PlusOneArrayDigits {

    public static int[] plusOne(int[] digits) {
        List<Integer> result = new LinkedList<>();

        int carry=1;
        for(int i=digits.length-1; i>=0; i--) {
            int num = carry + digits[i];
            result.add(num % 10);
            carry = num / 10;
        }

        if(carry > 0) {
            result.add(carry);
        }

        int[] ans = new int[result.size()];
        int i = ans.length-1;
        for(Integer digit : result) {
            ans[i--] = digit;
        }
        return ans;
    }

}
