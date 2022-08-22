package com.leetcode.problems.hard;

import java.util.ArrayList;
import java.util.List;

public final class NumberOfIslandsV2 {
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        List<Integer> ans = new ArrayList<>(positions.length);

        UnionFind uf = new UnionFind(m * n);
        for(int[] pos : positions) {
            int row=pos[0], col=pos[1];
            int idx=row*n+col;

            // we are an island by ourselves initially
            uf.set(idx);

            // check neighbors if we are part of an existing island
            for(int[] dir : dirs) {
                int nr=row+dir[0], nc=col+dir[1];
                int nidx = nr * n + nc;
                if(nr>=0 && nr<m && nc>=0 && nc<n) {
                    uf.union(idx, nidx);
                }
            }
            ans.add(uf.count);
        }

        return ans;
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private int count;

        UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            // initially no islands, no components.
            // we signify it by setting parents to -1.
            for(int i=0; i<n; i++) {
                parent[i]=-1;
                rank[i]=0;
            }
        }

        // when we first add a 1 cell, it becomes an island by itself
        void set(int x) {
            if(parent[x] < 0) {
                parent[x]=x;
                count++;
            }
        }

        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            // one of them is not a component, nothing to union
            if(parent[a] < 0 || parent[b] < 0) {
                return;
            }

            int pa = find(a);
            int pb = find(b);

            if(pa == pb) {
                return;
            }

            if(rank[pa] > rank[pb]) {
                parent[pb]=pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa]=pb;
                rank[pb] += rank[pa];
            }
            count--;
        }
    }

    // 3
    //3
    //[[0,0],[0,1],[1,2],[1,2]]
    public static void main(String[] args) {
        System.out.println(NumberOfIslandsV2.numIslands2(3,3, new int[][]{{0,0},{0,1},{1,2},{1,2}}));
    }
}
