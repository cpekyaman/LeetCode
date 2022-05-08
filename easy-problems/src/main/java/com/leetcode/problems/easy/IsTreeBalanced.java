package com.leetcode.problems.easy;

public final class IsTreeBalanced {
    public static boolean check(TreeNode root) {
        return balance(root).balanced;
    }

    private static NodeInfo balance(TreeNode node) {
        if(node == null) {
            return new NodeInfo(-1, true);
        }

        NodeInfo left = balance(node.left);
        NodeInfo right = balance(node.right);

        if(! (left.balanced && right.balanced)) {
            return new NodeInfo(-1, false);
        }

        int h = 1 + Integer.max(left.height, right.height);
        boolean b = Math.abs(left.height - right.height) < 2;
        return new NodeInfo(h, b);
    }

    private static class NodeInfo {
        private int height;
        private boolean balanced;

        NodeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    private static class TreeNode {
        private int val;
        private TreeNode left, right;
    }
}
