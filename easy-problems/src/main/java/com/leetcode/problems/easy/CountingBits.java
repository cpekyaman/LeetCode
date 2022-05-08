package com.leetcode.problems.easy;

import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {
        int[] counts = new int[n+1];

        int x = 0;
        int b = 1;

        // for b (2,4,8,...), for nums x < b bits(x+b) = bits(x) + 1.
        // we are essentially adding a new most significant bit for each of those numbers.

        // increasing b
        while(b <= n) {
            // calculating bits(x+b) for this b
            while(x < b && x + b <= n) {
                counts[x + b] = counts[x] + 1;
                x++;
            }
            // start over
            x = 0;
            // with doubling the range
            b <<= 1;
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CountingBits.countBits(5)));
    }
}
