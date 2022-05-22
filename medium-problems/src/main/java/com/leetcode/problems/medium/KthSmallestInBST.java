package com.leetcode.problems.medium;

import java.util.Deque;
import java.util.LinkedList;

public final class KthSmallestInBST {
    public static int find(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        int pos = 0;
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            pos++;
            root = stack.pop();
            if(pos == k) {
                return root.val;
            }
            root = root.right;
        }
    }
}
