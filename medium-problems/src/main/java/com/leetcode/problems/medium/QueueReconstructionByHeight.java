package com.leetcode.problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // we sort people by h desc and k asc.
        Arrays.sort(people, (a, b) -> {
            int cmp = Integer.compare(b[0], a[0]);
            if(cmp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return cmp;
        });

        // get people ordered by their height first.
        // and place them with their k values increasing order.
        // each people with same height will be placed correctly relative to their k values.
        // for people i,j with j>i and hj < hi, j can be placed in front of i.
        // as height of j does not prevent the k value placement of i.
        List<int[]> ordered = new LinkedList<>();
        for(int[] p : people) {
            ordered.add(p[1], p);
        }

        // simply build the answer
        int[][] ans = new int[ordered.size()][];
        for(int i=0; i<ordered.size(); i++) {
            ans[i]=ordered.get(i);
        }
        return ans;
    }
}
