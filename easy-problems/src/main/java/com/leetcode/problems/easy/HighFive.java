package com.leetcode.problems.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public final class HighFive {
    public static int[][] find(int[][] items) {
        Arrays.sort(items, (a1, a2) -> {
            int comp = Integer.compare(a1[0],a2[0]);
            if(comp == 0) {
                return Integer.compare(a2[1], a1[1]);
            }
            return comp;
        });

        Map<Integer, int[]> scores = new LinkedHashMap<>();
        for(int[] item : items) {
            int[] score = scores.computeIfAbsent(item[0], i -> new int[2]);
            if(score[0] < 5) {
                score[1] += item[1];
                score[0] += 1;
            }
        }

        int[][] result = new int[scores.size()][];
        int i=0;
        for(Map.Entry<Integer, int[]> entry : scores.entrySet()) {
            result[i++] = new int[]{entry.getKey(), entry.getValue()[1] / 5};
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = HighFive.find(new int[][]{
                {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77},
                {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}
        });
        for(int[] item : result) {
            System.out.println(Arrays.toString(item));
        }
    }
}
