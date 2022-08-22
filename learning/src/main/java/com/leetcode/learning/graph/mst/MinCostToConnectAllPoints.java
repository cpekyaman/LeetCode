package com.leetcode.learning.graph.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for(int v=0; v<points.length-1; v++) {
            for(int w=v+1; w<points.length; w++) {
                int weight = Math.abs(points[v][0]-points[w][0])
                        + Math.abs(points[v][1]-points[w][1]);

                edges.add(new Edge(v, w, weight));
            }
        }
        edges.sort(Comparator.comparingInt(e -> e.weight));

        UnionFind uf = new UnionFind(points.length);
        int cost=0, used=0;
        for(Edge e : edges) {
            if(used == points.length-1) {
                break;
            }
            if(uf.union(e.from, e.to)) {
                used++;
                cost += e.weight;
            }
        }
        return cost;
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
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int a, int b) {
            int pa = find(a), pb = find(b);

            if(pa == pb) {
                return false;
            }

            if(rank[a] > rank[b]) {
                parent[pb]=pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa]=pb;
                rank[pb] += rank[pa];
            }

            return true;
        }
    }

    private static final class Edge {
        private final int from;
        private final int to;
        private final int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
