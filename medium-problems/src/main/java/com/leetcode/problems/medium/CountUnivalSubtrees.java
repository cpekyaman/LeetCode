package com.leetcode.problems.medium;

public final class CountUnivalSubtrees {
    // a kind of marker value, it would mean subtree is not unival
    private static final int NO_UNIVAL = -2000;

    public static int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Counter c = new Counter();
        countUnival(root, c);
        return c.count;
    }

    private static int countUnival(TreeNode node, Counter c) {
        if(node.left == null && node.right == null) {
            c.incr();
            return node.val;
        }

        boolean isUnival = (node.left == null || node.val == countUnival(node.left, c))
                & (node.right == null || node.val == countUnival(node.right, c));

        if(isUnival) {
            c.incr();
            return node.val;
        }
        return NO_UNIVAL;
    }

    private static final class Counter {
        private int count;

        void incr() {
            count++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                                     new TreeNode(1,
                                                  new TreeNode(5),
                                                  new TreeNode(5)),
                                     new TreeNode(5,
                                                  null,
                                                  new TreeNode(5)));

        System.out.println(CountUnivalSubtrees.count(root));
    }
}
