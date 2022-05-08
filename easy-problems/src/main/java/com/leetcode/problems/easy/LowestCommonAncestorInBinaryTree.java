package com.leetcode.problems.easy;

public final class LowestCommonAncestorInBinaryTree {
    public static TreeNode find(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode ancestor = root;

        while(ancestor != null) {
            if(ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else if(ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else {
                return ancestor;
            }
        }

        return null;
    }

    private static class TreeNode {
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
