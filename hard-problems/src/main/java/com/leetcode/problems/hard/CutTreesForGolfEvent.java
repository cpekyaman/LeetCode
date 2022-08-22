package com.leetcode.problems.hard;

import java.util.*;

public class CutTreesForGolfEvent {
    // four directions we are allowed to move.
    private static final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.isEmpty()) {
            return 0;
        }

        // since we need to cut trees from shortest to tallest, sort them by height.
        Queue<Tree> trees = new PriorityQueue<>(Comparator.naturalOrder());

        for(int row=0; row<forest.size(); row++) {
            for(int col=0; col<forest.get(0).size(); col++) {
                if(forest.get(row).get(col) > 1) {
                    trees.offer(new Tree(row, col, forest.get(row).get(col)));
                }
            }
        }

        // start from origin point and go to the next shortest tree.
        // whenever we reach a tree, that tree will be our next start point and we repeat the process.
        // we'll be adding steps for (start, tree) to totalSteps.
        Cell startCell = new Cell(0, 0);
        int totalSteps=0;
        while(! trees.isEmpty()) {
            Tree tree = trees.poll();
            int steps = cutTree(forest, startCell, tree);
            // if a tree is not reachable, we stop as we can't go further.
            if(steps < 0) {
                return -1;
            }
            // update steps and set our next start position.
            totalSteps += steps;
            startCell = tree.cell;
        }
        return totalSteps;
    }

    // trying to go from current position to target tree in bfs manner.
    // and we count the steps we take, we return the steps we take or -1 if we can't reach.
    private int cutTree(List<List<Integer>> forest, Cell startCell, Tree tree) {
        final int m = forest.size();
        final int n = forest.get(0).size();

        boolean[][] visited = new boolean[m][n];
        Queue<Cell> path = new ArrayDeque<>();

        path.offer(startCell);
        visited[startCell.row][startCell.col] = true;

        int steps=0;
        while(! path.isEmpty()) {

            // level order traversal for bfs
            int sz = path.size();

            for(int i=0; i<sz; i++) {
                Cell current = path.poll();
                if(current.isSame(tree.cell)) {
                    return steps;
                }

                // try neighboring cells which are not visited and are not blocked
                for(int[] dir : dirs) {
                    int row = current.row + dir[0];
                    int col = current.col + dir[1];
                    if(row>=0 && row<m && col>=0 && col<n
                            && forest.get(row).get(col) != 0
                            && ! visited[row][col]) {

                        visited[row][col] = true;
                        path.offer(new Cell(row, col));
                    }
                }
            }

            steps++;
        }

        // we can't reach the tree.
        return -1;
    }

    private static final class Tree implements Comparable<Tree> {
        private final Cell cell;
        private final int height;

        Tree(int r, int c, int h) {
            this.cell = new Cell(r, c);
            this.height = h;
        }

        public int compareTo(Tree other) {
            return Integer.compare(this.height, other.height);
        }
    }

    private static final class Cell {
        private final int row;
        private final int col;

        Cell(int r, int c) {
            this.row = r;
            this.col = c;
        }

        public boolean isSame(Cell other) {
            return this.row == other.row && this.col == other.col;
        }
    }
}
