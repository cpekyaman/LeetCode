package com.leetcode.problems.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class UniqueBSTV2 {
    public static List<TreeNode> generate(int n) {
        if(n <= 0) {
            return Collections.emptyList();
        }
        return generate(1, n);
    }

    private static List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new LinkedList<>();

        if(start > end) {
            result.add(null);
            return result;
        }

        for(int i=start; i <= end; i++) {
            List<TreeNode> left = generate(start, i-1);
            List<TreeNode> right = generate(i+1, end);

            for(TreeNode lr : left) {
                for(TreeNode rr : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lr;
                    root.right = rr;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
