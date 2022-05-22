package com.leetcode.problems.medium;

public final class PopulateNextPointersV2 {
    public static Node connect(Node root) {
        if(root == null) {
            return null;
        }
        connectNode(root);
        return root;
    }

    private static void connectNode(Node node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            node.left.next = node.right != null ? node.right : findNext(node.next);
        }
        if(node.right != null) {
            node.right.next = findNext(node.next);
        }

        // go to right first, otherwise left nodes can't reach rightmost node
        // as some next links won't be set up yet on the right side
        connectNode(node.right);
        connectNode(node.left);
    }

    private static Node findNext(Node next) {
        while(next != null && next.left == null && next.right == null) {
            next = next.next;
        }
        if(next == null) {
            return null;
        }
        return next.left != null ? next.left : next.right;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2,
                             new Node(1,
                                      new Node(0, new Node(2), null),
                                      new Node(7, new Node(1), new Node(0, new Node(7), null))),
                             new Node(3,
                                      new Node(9),
                                      new Node(1, new Node(8), new Node(8))));

        PopulateNextPointersV2.connect(root);

        System.out.println(root);
    }
}
