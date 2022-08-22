package com.leetcode.learning.graph.disjointset;

public final class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            if(! uf.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    private static final class UnionFind {
        private final int[] root;
        private final int[] rank;

        UnionFind(int n) {
            this.root = new int[n];
            this.rank = new int[n];

            for(int i=0; i<n; i++) {
                root[i]=i;
                rank[i]=1;
            }
        }

        private int findRoot(int x) {
            if(x != root[x]) {
                root[x] = findRoot(root[x]);
            }
            return root[x];
        }

        private boolean union(int a, int b) {
            int aroot = findRoot(a);
            int broot = findRoot(b);

            if(aroot == broot) {
                return false;
            }

            if(rank[aroot] > rank[broot]) {
                root[broot] = aroot;
                rank[aroot] += rank[broot];
            } else {
                root[aroot] = broot;
                rank[broot] += rank[aroot];
            }

            return true;
        }
    }
}
