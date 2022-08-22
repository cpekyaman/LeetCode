package com.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

public final class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // x: alice exchange, y: bob exchange
        // sumAlice - x + y = sumBob + x -y
        // y-x=(sumBob-sumAlice) / 2

        int aliceSum=0, bobSum=0;
        for(int size : aliceSizes) {
            aliceSum += size;
        }

        // will be used for a variation of two sum
        Set<Integer> bobSize = new HashSet<>();

        for(int size : bobSizes) {
            bobSum += size;
            bobSize.add(size);
        }

        int diff = (bobSum - aliceSum) / 2;

        // if there is a pair that satisfies the above equation, we return it
        for(int x : aliceSizes) {
            if(bobSize.contains(x + diff)) {
                return new int[]{x, x+diff};
            }
        }

        // not pair found
        return null;
    }
}
