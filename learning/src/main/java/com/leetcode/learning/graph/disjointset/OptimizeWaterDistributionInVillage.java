package com.leetcode.learning.graph.disjointset;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class OptimizeWaterDistributionInVillage {
    public static int findMinCost(int n, int[] wells, int[][] pipes) {
        List<Edge> edges = new ArrayList<>(n+1+pipes.length);

        // virtual node from well(s) to each house
        for(int i=0; i<wells.length; i++) {
            edges.add(new Edge(0,i+1,wells[i]));
        }
        // edges for each pipe
        for(int i=0; i<pipes.length; i++) {
            edges.add(new Edge(pipes[i][0], pipes[i][1], pipes[i][2]));
        }

        edges.sort(Comparator.comparingInt(e -> e.w));

        UnionFind uf = new UnionFind(n+1);
        int total=0;
        for(Edge edge : edges) {
            if(uf.union(edge.from, edge.to)) {
                total+=edge.w;
            }
        }
        return total;
    }

    private static final class Edge {
        private int from;
        private int to;
        private int w;

        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i=0; i<n; i++) {
                parent[i]=i;
                rank[i]=1;
            }
        }

        private int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if(ra == rb) {
                return false;
            }

            if(rank[ra] > rank[rb]) {
                parent[rb]=ra;
                rank[ra] += rank[rb];
            } else {
                parent[ra]=rb;
                rank[rb]+=rank[ra];
            }

            return true;
        }
    }
}
