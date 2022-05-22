package com.leetcode.problems.medium;

public final class CountPrimes {
    public static int count(int n) {
        if(n <= 2) {
            return 0;
        }

        int end = (int) Math.sqrt(n);
        boolean[] marked = new boolean[n];
        for(int i=2;i < end; i++) {
            if(! marked[i]) {
                for(int j=i*i; j < n; j+=i) {
                    marked[j] = true;
                }
            }
        }

        int count=-2;
        for(boolean m : marked) {
            if(m) {
                count++;
            }
        }
        return count;
    }
}
