package com.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode marker = new TreeNode(-1);

        if(root == null) {
            return false;
        }

        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.offer(root);

        while(! bfs.isEmpty()) {
            boolean sameParent=true, xfound=false, yfound=false;

            int sz = bfs.size();

            for(int i=0; i<sz; i++) {
                TreeNode curr = bfs.poll();
                // if we see marker, next node comes from another parent.
                // we set sameParent=false when either one is found before marker.
                // if both of them were found before marker, we wouldn't even reach here.
                if(curr == marker) {
                    sameParent = ! (xfound || yfound);
                    continue;
                }

                xfound = xfound || curr.val == x;
                yfound = yfound || curr.val == y;

                // if both are found, check if they are from same parent.
                if(xfound && yfound) {
                    return ! sameParent;
                }

                // insert children for the next level.
                if(curr.left != null) {
                    bfs.offer(curr.left);
                }
                if(curr.right != null) {
                    bfs.offer(curr.right);
                }
                // to mark end of node coming from same parent
                bfs.offer(marker);
            }

            // if either one is found at last level, they are not at same depth.
            if(xfound || yfound) {
                return false;
            }
        }

        return false;
    }

    private static final class TreeNode {
        private int val;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        System.out.println(new CousinsInBinaryTree().isCousins(root, 5, 8));
    }
}
