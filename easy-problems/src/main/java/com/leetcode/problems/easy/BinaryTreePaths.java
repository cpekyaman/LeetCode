package com.leetcode.problems.easy;

import java.util.LinkedList;
import java.util.List;

public final class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        traverse(root, paths, new StringBuilder());
        return paths;
    }

    private void traverse(TreeNode node, List<String> paths, StringBuilder path) {
        if(node == null) {
            return;
        }

        int len = path.length();
        if(path.length() > 0) {
            path.append("->");
        }
        path.append(node.val);

        if(node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            traverse(node.left, paths, path);
            traverse(node.right, paths, path);
        }
        path.setLength(len);
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
