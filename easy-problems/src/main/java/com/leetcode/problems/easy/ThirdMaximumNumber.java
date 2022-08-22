package com.leetcode.problems.easy;

public final class ThirdMaximumNumber {
    public static int find(int[] nums) {
        final long MIN = (long)Integer.MIN_VALUE-1;
        long first=MIN, second=MIN, third=MIN;
        for(int num : nums) {
            if(num == first || num == second || num == third) {
                continue;
            }

            if(num > first) {
                third = second;
                second = first;
                first = num;
            } else if(num > second) {
                third = second;
                second = num;
            } else if(num > third) {
                third=num;
            }
        }

        if(third != MIN) {
            return (int) third;
        }
        return (int)first;
    }

    public static void main(String[] args) {
        System.out.println(ThirdMaximumNumber.find(new int[]{3,2,1}));
    }
}
