package com.leetcode.learning.heap;

import java.util.Arrays;
import java.util.Random;

public final class KPointsClosestToOrigin {
    private final Random random = new Random();

    public int[][] find(int[][] points, int k) {
        quickSelect(points, k);
        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int k) {
        int left=0, right=points.length-1, pivotIndex=points.length;

        while(pivotIndex != k && left < right) {
            pivotIndex = partition(points, left, right);
            if(pivotIndex == k) {
                break;
            } else if(pivotIndex < k) {
                left=pivotIndex+1;
            } else {
                right=pivotIndex-1;
            }
        }
    }

    private int partition(int[][] points, int left, int right) {
        int pivotIndex = left + random.nextInt(right-left);
        int pivot = dist(points[pivotIndex]);

        swap(points, pivotIndex, right);
        int store=left;
        for(int i=left; i<=right; i++) {
            if(dist(points[i]) < pivot) {
                swap(points, store, i);
                store++;
            }
        }

        swap(points, store, right);
        return store;
    }

    private void swap(int[][] points, int i, int j) {
        int[] p = points[i];
        points[i] = points[j];
        points[j] = p;
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}
