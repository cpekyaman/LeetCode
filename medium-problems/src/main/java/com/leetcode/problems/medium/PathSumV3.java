package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public final class PathSumV3 {
    public int pathSum(TreeNode root, int targetSum) {
        State state = new State();
        pathSum(root, targetSum, state, 0);
        return state.count;
    }

    private void pathSum(TreeNode node, int targetSum, State state, int currentSum) {
        if(node == null) {
            return;
        }

        currentSum += node.val;
        // we hit the target for the root-to-node sum
        if(currentSum == targetSum) {
            state.count += 1;
        }

        // if there were nodes with currentSum-targetSum as their currentSum,
        // the sum between those nodes and this one is counted that many times.
        state.count += state.sumOccurs.getOrDefault(currentSum-targetSum, 0);

        // add our sum to number of times this sum occurred (for the subtrees to use it)
        state.sumOccurs.compute(currentSum, (k,v) -> v == null ? 1 : v+1);

        pathSum(node.left, targetSum, state, currentSum);
        pathSum(node.right, targetSum, state, currentSum);

        // sort-of backtracking to prevent usage of this current sum in the side subtrees
        state.sumOccurs.compute(currentSum, (k,v) -> v-1);
    }

    private static final class State {
        private int count;
        private final Map<Integer, Integer> sumOccurs;

        State() {
            count=0;
            sumOccurs = new HashMap<>();
        }
    }
}
