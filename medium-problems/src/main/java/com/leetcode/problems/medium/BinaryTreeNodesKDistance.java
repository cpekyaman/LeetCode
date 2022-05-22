package com.leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

public final class BinaryTreeNodesKDistance {
    public static List<Integer> find(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Set<TreeNode>> adj = new HashMap<>();

        treeToGraph(root, adj);

        Queue<TreeNode> nodes = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        nodes.offer(target);
        visited.add(target);

        int dist = 0;

        while(! nodes.isEmpty() && dist < k) {
            int size = nodes.size();
            for(int i=0; i<size; i++) {
                TreeNode current = nodes.poll();
                for(TreeNode adjNode : adj.get(current)) {
                    if(! visited.contains(adjNode)) {
                        nodes.offer(adjNode);
                        visited.add(adjNode);
                    }
                }
            }
            dist++;
        }

        return nodes.stream().map(n -> n.val).collect(Collectors.toList());
    }

    private static void treeToGraph(TreeNode node, Map<TreeNode, Set<TreeNode>> adj) {
        if(node == null) {
            return;
        }

        adj.putIfAbsent(node, new HashSet<>());

        if(node.left != null) {
            adj.get(node).add(node.left);
            adj.computeIfAbsent(node.left, n -> new HashSet<>()).add(node);
            treeToGraph(node.left, adj);
        }

        if(node.right != null) {
            adj.get(node).add(node.right);
            adj.computeIfAbsent(node.right, n -> new HashSet<>()).add(node);
            treeToGraph(node.right, adj);
        }
    }
}
