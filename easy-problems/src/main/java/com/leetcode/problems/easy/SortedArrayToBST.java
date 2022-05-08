package com.leetcode.problems.easy;

public final class SortedArrayToBST {
    public static TreeNode convert(int[] nums) {
        return toBST(nums, 0, nums.length-1);
    }

    private static TreeNode toBST(int[] nums, int low, int high) {
        if(high < low) {
            return null;
        }

        int mid = low + (high-low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, low, mid-1);
        root.right = toBST(nums, mid+1, high);
        return root;
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
