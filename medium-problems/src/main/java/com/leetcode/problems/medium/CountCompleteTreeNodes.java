package com.leetcode.problems.medium;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // there is only root.
        int depth = findDepth(root);
        if(depth == 0) {
            return 1;
        }

        int leafCount = countLeafNodes(root, depth);

        // a complete tree excluding last level is a perfect tree.
        // a perfect tree of depth h has pow(2,h+1)-1 nodes (here h = depth-1).
        // and we also have the leaves.
        return (int)Math.pow(2, depth) - 1 + leafCount;
    }

    // trying to find right most occupied leaf.
    // all the leaves at the last level are on the leftmost side.
    // we pick a pivot index, check if a node exists there and move the pivot left or right.
    private int countLeafNodes(TreeNode root, int depth) {
        // we have at least one leaf, so we start from left=1.
        // each leaf is indexed from 1 to pow(2,d)-1.
        int left = 1, right = (int) Math.pow(2, depth) - 1;
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            if(found(root, pivot, depth)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        // left is the idx of right most leaf which is the count of leaf nodes.
        return left;
    }

    // trying to find if there is a corresponding node found at given target idx.
    private boolean found(TreeNode root, int target, int depth) {
        int left=0, right = (int) Math.pow(2, depth) - 1;
        int pivot=0;

        // starting from root we go from left or right at each level.
        // we chose the direction depending on how our pivot compares to given target idx.
        // loop ends at depth, as that's when we reach bottom level.
        for(int i=0; i<depth; i++) {
            pivot = left + (right - left) / 2;
            if(target <= pivot) {
                root = root.left;
                right = pivot;
            } else {
                root = root.right;
                left = pivot + 1;
            }
        }

        return root != null;
    }

    private int findDepth(TreeNode root) {
        // as this is a complete tree, we always go left to reach the bottom level.
        TreeNode node = root;
        int d = 0;
        while(node.left != null) {
            node = node.left;
            d++;
        }
        return d;
    }
}
