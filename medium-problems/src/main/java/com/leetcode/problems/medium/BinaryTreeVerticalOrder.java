package com.leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

public final class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        return dfs(root);
    }

    public List<List<Integer>> bfs(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        Map<Integer, List<Integer>> orderedNodes = new HashMap<>();

        Queue<ColumnNode> bfs = new ArrayDeque<>();
        bfs.offer(new ColumnNode(root, 0));

        while(! bfs.isEmpty()) {
            ColumnNode node = bfs.poll();
            if(node.node != null) {
                orderedNodes.computeIfAbsent(node.column, k -> new LinkedList<>()).add(node.node.val);
                bfs.offer(new ColumnNode(node.node.left, node.column - 1));
                bfs.offer(new ColumnNode(node.node.right, node.column + 1));
            }
        }

        List<Integer> columns = new ArrayList<>(orderedNodes.keySet());
        columns.sort(Comparator.naturalOrder());

        List<List<Integer>> ans = new ArrayList<>(orderedNodes.size());
        for(Integer column : columns) {
            ans.add(orderedNodes.get(column));
        }
        return ans;
    }

    private static class ColumnNode {
        private final TreeNode node;
        private final int column;

        ColumnNode(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> dfs(TreeNode root) {
        Map<Integer, List<NodeVal>> orderedNodes = new HashMap<>();
        traverse(root, 0, 0, orderedNodes);
        if(orderedNodes.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> columns = new ArrayList<>(orderedNodes.keySet());
        columns.sort(Comparator.naturalOrder());

        List<List<Integer>> ans = new ArrayList<>(orderedNodes.size());
        for(Integer column : columns) {
            List<NodeVal> nodes = orderedNodes.get(column);
            nodes.sort((a,b) -> Integer.compare(a.level, b.level));
            ans.add(nodes.stream().map(n -> n.val).collect(Collectors.toList()));
        }
        return ans;
    }

    private void traverse(TreeNode node, int level, int column, Map<Integer, List<NodeVal>> orderedNodes) {
        if(node == null) {
            return;
        }

        orderedNodes.computeIfAbsent(column, k -> new LinkedList<>()).add(new NodeVal(node.val, level));
        traverse(node.left, level+1, column-1, orderedNodes);
        traverse(node.right, level+1, column+1, orderedNodes);
    }

    private static class NodeVal {
        private final int val;
        private final int level;

        NodeVal(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

}
