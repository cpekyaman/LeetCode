package com.leetcode.problems.easy;

import java.util.Arrays;

public final class MaxUnitsOnATruck {
    public int solve(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int boxCount = 0;
        int unitCount = 0;
        for (int[] boxType : boxTypes) {
            if (boxCount == truckSize) {
                break;
            }
            int usedBoxes = Integer.min(truckSize - boxCount, boxType[0]);
            boxCount += usedBoxes;
            unitCount += usedBoxes * boxType[1];
        }
        return unitCount;
    }
}
