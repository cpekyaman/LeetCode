package com.leetcode.problems.medium;

public class PopulateNextPointersInTree {

    public static Node connect(Node root) {
        if(root == null) {
            return null;
        }
        connectNode(root);
        return root;
    }

    private static void connectNode(Node node) {
        if(node.left == null && node.right == null) {
            return;
        }

        node.left.next = node.right;
        if(node.next != null) {
            node.right.next = node.next.left;
        }

        connectNode(node.left);
        connectNode(node.right);
    }

    private static class Node {
        int val;
        Node left, right, next;
    }
}
