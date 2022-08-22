package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved {
    // we use this to differentiate between x vs y for union find.
    // we don't want to accidentally connect x=1 to y=1.
    // you can also create some Coord object which num and type, and union find on that.
    private static final int Y_OFFSET = 20_000;

    public int removeStones(int[][] stones) {
        // we connect x and y coordinates of each stone.
        UnionFind uf = new UnionFind(stones.length);
        for(int[] stone : stones) {
            uf.union(stone[0], stone[1]);
        }

        // we connected each stone to others if possible.
        // for each connected component, we have to leave one stone left.
        // we can't remove the last one, e.g. the root component of each group, due to the rules given.
        // so, the root components stay, the other stones are removed.
        return stones.length - uf.componentCount();
    }

    private static final class UnionFind {
        // we can also use arrays as the range for x,y can be considered as small.
        private final Map<Integer, Integer> parent;
        private final Map<Integer, Integer> rank;

        private int components;

        UnionFind(int n) {
            this.parent = new HashMap<>();
            this.rank = new HashMap<>();
        }

        private int find(Integer x) {
            // first time we see this index, new component.
            if(parent.putIfAbsent(x, x) == null) {
                components++;
            }

            // path compression.
            Integer p = parent.get(x);
            if(! p.equals(x)) {
                parent.put(x, find(p));
            }
            return parent.get(x);
        }

        // we either connect x to y (which is expected as they are the same stone).
        // or, if x or y is the same as another stone, we'll be connecting multiple stones via that edge.
        // we wiil end up with a new single component (x,y), or new stone connect with a previous stone.
        private void union(int x, int y) {
            int px = find(x);
            int py = find(Y_OFFSET + y);

            if(px == py) {
                return;
            }

            // weighted union
            int xrank = rank.getOrDefault(px, 1);
            int yrank = rank.getOrDefault(py, 1);
            if(xrank > yrank) {
                parent.put(py, px);
                rank.put(px, xrank + yrank);
            } else {
                parent.put(px, py);
                rank.put(py, xrank + yrank);
            }

            // we connected one existing component to another.
            components--;
        }

        private int componentCount() {
            return components;
        }
    }

    public static void main(String[] args) {
        MostStonesRemoved msr = new MostStonesRemoved();
        System.out.println(msr.removeStones(new int[][]{{0,1},{1,1},{2,1},{3,1},{4,1}}));
    }
}
