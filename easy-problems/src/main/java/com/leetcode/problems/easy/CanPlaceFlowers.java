package com.leetcode.problems.easy;

public final class CanPlaceFlowers {
    public static boolean solve(int[] flowerbed, int n) {
        int count=0, i=0, len = flowerbed.length;
        while(i<len) {
            if((i == 0 || flowerbed[i-1] == 0)
                    && flowerbed[i]==0
                    && (i==len-1 || flowerbed[i+1]==0)) {
                count++;
                i+=2;
            } else {
                i++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        System.out.println(CanPlaceFlowers.solve(new int[]{0,0,1,0,0}, 1));
    }
}
