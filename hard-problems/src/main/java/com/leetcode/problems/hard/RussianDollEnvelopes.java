package com.leetcode.problems.hard;

import java.util.Arrays;

public final class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        // order asc per width and descending per height.
        // it is to discard the second envelope in a possible sequence when h[i]==h[i+1].
        Arrays.sort(envelopes, (a,b) -> {
            int comp = Integer.compare(a[0], b[0]);
            if(comp == 0) {
                return Integer.compare(b[1], a[1]);
            }
            return comp;
        });

        // since envelopes are sorted from low to high for width, we use the heights array for LIS.
        // as the first dimension (width) is already guaranteed to be correct.
        // (we don't change any relative ordering between the sorted envelopes).
        int[] heights = new int[envelopes.length];
        int i=0;
        for(int[] env : envelopes) {
            heights[i++]=env[1];
        }

        // we try to build LIS from heights.
        // if new h is larger than all found, extend sequence.
        // otherwise, we replace one envelope from the sequence.
        // we are not interested in order of envelopes used, only the max number of used.
        int[] dp = new int[heights.length];
        int len=0;
        for(int h : heights) {
            // find where the h of new envelope fits in to the existing sequence.
            int index = Arrays.binarySearch(dp, 0, len, h);

            // this means h is not among elements added so far.
            // the returned value is -(insertionPoint+1).
            if(index < 0) {
                index = -(index+1);
            }

            dp[index]=h;

            // extending the sequence (or, the length of it).
            if(index == len) {
                len++;
            }
        }

        return len;
    }
}
