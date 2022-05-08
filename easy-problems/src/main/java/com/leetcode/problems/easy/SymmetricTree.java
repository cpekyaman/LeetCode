package com.leetcode.problems.easy;

public final class SymmetricTree {
    public boolean solve(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }

        if(left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && symmetric(left.right, right.left)
                && symmetric(left.left, right.right);
    }

    static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
