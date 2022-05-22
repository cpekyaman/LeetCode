package com.leetcode.problems.hard;

public final class BinaryTreeMaxPathSum {
    public static int find(TreeNode root) {
        return pathSum(root).sum;
    }

    private static NodeInfo pathSum(TreeNode node) {
        if(node == null) {
            return new NodeInfo(0);
        }

        NodeInfo leftSum = pathSum(node.left);
        NodeInfo rightSum = pathSum(node.right);

        int leftPath = Integer.max(0, leftSum.path);
        int rightPath = Integer.max(0, rightSum.path);
        int mysum = node.val + leftPath + rightPath;

        int maxSum = Integer.max(mysum, Integer.max(leftSum.sum, rightSum.sum));

        return new NodeInfo(maxSum, node.val + Integer.max(leftPath, rightPath));
    }

    private static class NodeInfo {
        private int path;
        private int sum;

        NodeInfo(int sum) {
            this.sum = sum;
        }

        NodeInfo(int sum, int path) {
            this.sum = sum;
            this.path = path;
        }
    }
}
