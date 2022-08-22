package com.leetcode.problems.hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
    public int oddEvenJumps(int[] arr) {
        final int n = arr.length;

        // these are our dp arrays.
        // they represent whether we can do a highJump or lowJump from position i.
        boolean[] oddHighJump = new boolean[n];
        boolean[] evenLowJump = new boolean[n];

        // we can reach end from end with 0 jumps
        oddHighJump[n-1]=true;
        evenLowJump[n-1]=true;
        int count = 1;

        // this is to determine the possible high or low jump values and their index.
        TreeMap<Integer, Integer> valueToIdx = new TreeMap<>();
        valueToIdx.put(arr[n-1], n-1);

        for(int i=n-2; i>=0; i--) {
            // smallest value > arr[i]
            Map.Entry<Integer,Integer> oddJumpVal = valueToIdx.ceilingEntry(arr[i]);
            // largest value < arr[i]
            Map.Entry<Integer,Integer> evenJumpVal = valueToIdx.floorEntry(arr[i]);

            // if we can do a high jump and destination can do a low jump
            if(oddJumpVal != null) {
                oddHighJump[i] = evenLowJump[oddJumpVal.getValue()];
            }
            // if we can do a low jump and destination can do a high jump
            if(evenJumpVal != null) {
                evenLowJump[i] = oddHighJump[evenJumpVal.getValue()];
            }

            // a starting jump should be odd (1st jump).
            // so, we start start positions count if we can do an odd jump at i.
            if(oddHighJump[i]) {
                count++;
            }

            valueToIdx.put(arr[i], i);
        }

        return count;
    }
}
