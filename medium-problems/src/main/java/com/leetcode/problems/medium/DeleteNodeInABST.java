package com.leetcode.problems.medium;

public final class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode succ = min(root.right);
                succ.right = removeMin(root.right);
                succ.left = root.left;
                return succ;
            }
        }
        return root;
    }

    private TreeNode min(TreeNode node) {
        if(node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        if(node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
