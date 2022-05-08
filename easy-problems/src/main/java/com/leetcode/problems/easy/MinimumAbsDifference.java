package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MinimumAbsDifference {
    public static List<List<Integer>> find(int[] arr) {
        Arrays.sort(arr);

        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++) {
            min = Integer.min(min, arr[i] - arr[i-1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<arr.length; i++) {
            if(arr[i] - arr[i-1] == min) {
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return result;
    }
}
