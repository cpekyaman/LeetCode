package com.leetcode.learning.graph.disjointset;

public final class NumberOfProvinces {
    public static int find(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);

        for(int row=0; row<isConnected.length; row++) {
            for(int col=0; col<isConnected[0].length; col++) {
                if(row != col && isConnected[row][col]==1) {
                    uf.union(row, col);
                }
            }
        }

        return uf.rootCount();
    }

    static final class UnionFind {
        private final int[] union;
        private final int[] rank;

        UnionFind(int n) {
            this.union = new int[n];
            this.rank = new int[n];
            for(int i=0; i<n; i++) {
                union[i]=i;
                rank[i]=1;
            }
        }

        private int find(int x) {
            if(union[x] != x) {
                union[x] = find(union[x]);
            }
            return union[x];
        }

        private void union(int a, int b) {
            int aroot = find(a);
            int broot = find(b);

            if(aroot == broot) {
                return;
            }

            int arank = rank[aroot], brank=rank[broot];
            if(arank > brank) {
                union[broot]=aroot;
                rank[aroot]+=rank[broot];
            } else {
                union[aroot]=broot;
                rank[broot]+=rank[aroot];
            }
        }

        private int rootCount() {
            int cnt=0;
            for(int i=0; i<union.length; i++) {
                if(i == union[i]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        // 0-3
        // 1-2
        // 2-1, 2-3
        // 3-0, 3-2
        int[][] cities = new int[][] {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        int ans = NumberOfProvinces.find(cities);
        System.out.println(ans);
    }
}
