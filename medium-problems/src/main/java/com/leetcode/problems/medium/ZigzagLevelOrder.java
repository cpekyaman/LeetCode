package com.leetcode.problems.medium;

import java.util.*;

public final class ZigzagLevelOrder {
    public static List<List<Integer>> traverse(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        boolean left = true;

        List<List<Integer>> ans = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> level = new LinkedList<>();
            for(int i=0; i<sz; i++) {
                TreeNode node = queue.poll();
                if(left) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(level);
            left = !left;
        }

        return ans;
    }

}
