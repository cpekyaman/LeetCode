package com.leetcode.learning.graph.disjointset;

import java.util.*;

// since we can reuse pairs, we can swap any char with any other char under a single root component.
// the solution is finding the root components and sorting each char under the same component.
// then we build the answer by adding sorted chars to answer per each root.
public final class SmallestStringWithSwaps {
    public static String find(String s, List<List<Integer>> pairs) {

        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for(int v=0; v<s.length(); v++) {
            rootToComponent.computeIfAbsent(uf.findRoot(v), k-> new ArrayList<>()).add(v);
        }

        char[] ans = new char[s.length()];
        // since we iterate vertices from 0, the comp is already sorted
        for(List<Integer> comp : rootToComponent.values()) {
            List<Character> chars = new ArrayList<>(comp.size());
            for(Integer c : comp) {
                chars.add(s.charAt(c));
            }
            Collections.sort(chars);

            for(int i=0; i<chars.size(); i++) {
                ans[comp.get(i)]=chars.get(i);
            }
        }
        return new String(ans);
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

        private void union(int a, int b) {
            int aroot = findRoot(a);
            int broot = findRoot(b);

            if(aroot == broot) {
                return;
            }

            if(rank[aroot] > rank[broot]) {
                root[broot] = aroot;
                rank[aroot] += rank[broot];
            } else {
                root[aroot] = broot;
                rank[broot] += rank[aroot];
            }
        }
    }
}
