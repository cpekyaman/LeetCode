package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class NestedListWeightSumV2 {
    public static int sum(List<NestedInteger> nestedList) {
        List<List<Integer>> numsPerLevel = new ArrayList<>();
        sum(1, nestedList, numsPerLevel);

        int maxDepth = numsPerLevel.size(), total=0;
        for(int i=0; i<numsPerLevel.size(); i++) {
            int mul = maxDepth - i, rowSum=0;
            for(Integer num : numsPerLevel.get(i)) {
                rowSum += num;
            }
            total += rowSum * mul;
        }

        return total;
    }

    private static void sum(int level, List<NestedInteger> nestedList, List<List<Integer>> numsPerLevel) {
        if(numsPerLevel.size() < level) {
            numsPerLevel.add(new ArrayList<>());
        }

        for(NestedInteger n : nestedList) {
            if(n.getInteger() != null) {
                numsPerLevel.get(level-1).add(n.getInteger());
            } else {
                sum(level+1, n.getList(), numsPerLevel);
            }
        }
    }

    private static class NestedInteger {
        private Integer value;
        private List<NestedInteger> values;

        public NestedInteger(Integer value) {
            this.value = value;
        }

        public NestedInteger(List<NestedInteger> values) {
            this.values = values;
        }

        public List<NestedInteger> getList() {
            return values;
        }

        public Integer getInteger() {
            return value;
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> list = List.of(new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1))),
                                           new NestedInteger(2),
                                           new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1))));

        System.out.println(NestedListWeightSumV2.sum(list));
    }
}
