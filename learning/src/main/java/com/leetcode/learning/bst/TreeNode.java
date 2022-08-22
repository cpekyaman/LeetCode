package com.leetcode.learning.bst;

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
        return String.format("Node( %d )", val);
    }
}
