package com.leetcode.problems.easy;

// Floyd's Cycle-Finding Algorithm
public final class HappyNumber {
    public boolean determine(int n) {
        int slowPointer = n;
        int fastPointer = nextInChain(n);
        while(fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = nextInChain(slowPointer);
            fastPointer = nextInChain(nextInChain(fastPointer));
        }
        return fastPointer == 1;
    }

    private int nextInChain(int n) {
        int sum = 0;
        int number = n;
        while(number > 0) {
            int d = number % 10;
            number = number / 10;
            sum += d*d;
        }
        return sum;
    }
}
