package com.leetcode.problems.easy;

public final class FindSqrtOfX {
    public static int find(int x) {
        if(x < 2) {
            return x;
        }

        int left=2, right=x/2, pivot=0;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            long sq = (long) pivot * pivot;
            if(sq > x) {
                right = pivot-1;
            } else if(sq < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return right;
    }
}
