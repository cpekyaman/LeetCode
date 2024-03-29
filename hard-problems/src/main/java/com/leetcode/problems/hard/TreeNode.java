package com.leetcode.problems.hard;

final class TreeNode {
    final int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + this.val + "," + this.left + "," + this.right + ")";
    }
}
