package com.leetcode.learning.heap;

import java.util.PriorityQueue;

public final class KWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> rows = new PriorityQueue<>((a, b) -> {
            int strComp = Integer.compare(b[0], a[0]);
            if(strComp == 0) {
                return Integer.compare(b[1], a[1]);
            }
            return strComp;
        });

        for(int r=0; r<mat.length; r++) {
            rows.add(new int[]{strength(mat[r]), r});
            if(rows.size() > k) {
                rows.poll();
            }
        }

        int[] ans = new int[k];
        int i = ans.length-1;
        while(! rows.isEmpty()) {
            ans[i--]=rows.poll()[1];
        }
        return ans;
    }

    // we can use binary search to find last 1 and count index of it
    private int strength(int[] row) {
        int str=0;
        for(int i : row) {
            if(i == 0) {
                break;
            }
            str++;
        }
        return str;
    }
}
