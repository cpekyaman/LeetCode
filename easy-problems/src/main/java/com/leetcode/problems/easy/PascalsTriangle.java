package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public final class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        generate(numRows, pascal);
        return pascal;
    }

    private void generate(int n, List<List<Integer>> pascal) {
        if(n == 1) {
            pascal.add(List.of(1));
            return;
        }

        generate(n-1, pascal);

        List<Integer> previousRow = pascal.get(pascal.size() - 1);
        List<Integer> row = new ArrayList<>(n);
        row.add(1);
        for(int i=1; i < n-1; i++) {
            row.add(previousRow.get(i) + previousRow.get(i-1));
        }
        row.add(1);

        pascal.add(row);
    }
}