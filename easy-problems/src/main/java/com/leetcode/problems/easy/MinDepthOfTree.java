package com.leetcode.problems.easy;

import java.util.Deque;
import java.util.LinkedList;

public final class MinDepthOfTree {
    public static int find(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth=1;
        while(! queue.isEmpty()) {
            int sz = queue.size();
            for(int i=0; i < sz; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) {
                    return depth;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left, right;
    }
}
