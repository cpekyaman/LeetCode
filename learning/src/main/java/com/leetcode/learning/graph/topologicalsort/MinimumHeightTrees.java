package com.leetcode.learning.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 0) {
            return Collections.emptyList();
        }

        if(n == 1) {
            return List.of(0);
        }

        List<List<Integer>> adjMatrix = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            adjMatrix.add(new LinkedList<>());
        }

        // build the graph (undirected)
        int[] inDegree = new int[n];
        for(int[] edge : edges) {
            int v=edge[0], w=edge[1];
            adjMatrix.get(v).add(w);
            adjMatrix.get(w).add(v);

            inDegree[v]++;
            inDegree[w]++;
        }

        // a leaf has only one edge to/from it
        List<Integer> leaves = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(inDegree[i] == 1) {
                leaves.add(i);
            }
        }

        // clear each layer of leaves to reach inner layers.
        // stop when we have at most two nodes (max number of centroids in such a tree).
        int totalNodes = n;
        while(totalNodes > 2) {
            int lcount = leaves.size();
            totalNodes -= lcount;

            while(lcount > 0) {
                int v = leaves.remove(0);
                lcount--;
                for(int w : adjMatrix.get(v)) {
                    if(--inDegree[w] == 1) {
                        leaves.add(w);
                    }
                }
            }
        }

        // remaining nodes are MHT roots
        return leaves;
    }
}
