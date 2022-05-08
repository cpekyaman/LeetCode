package com.leetcode.problems.easy;

public final class HammingDistance {
    public static int find(int x, int y) {
        int z = x ^ y;

        int dist=0;
        while(z != 0) {
            dist++;
            z = (z & z-1);
        }
        return dist;
    }

}
