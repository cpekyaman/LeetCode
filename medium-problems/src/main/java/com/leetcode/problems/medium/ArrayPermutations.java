package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ArrayPermutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        List<List<Integer>> ans = new ArrayList<>();
        permutation(numsList, 0, ans);
        return ans;
    }

    private static void permutation(List<Integer> numsList, int i, List<List<Integer>> ans) {
        if(i == numsList.size()-1) {
            ans.add(new ArrayList<>(numsList));
            return;
        }

        for(int j=i; j < numsList.size(); j++) {
            Collections.swap(numsList, i, j);
            permutation(numsList, i+1, ans);
            Collections.swap(numsList, i, j);
        }
    }
}
