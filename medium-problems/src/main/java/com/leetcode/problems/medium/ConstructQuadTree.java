package com.leetcode.problems.medium;

public final class ConstructQuadTree {
    public static Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private static Node construct(int[][] grid, int row, int col, int size) {
        if(size == 1) {
            return new Node(grid[row][col]==1, true);
        }

        Node topLeft = construct(grid, row, col, size/2);
        Node topRight = construct(grid, row, col+size/2, size/2);
        Node bottomLeft = construct(grid, row+size/2, col, size/2);
        Node bottomRight = construct(grid, row+size/2, col+size/2, size/2);

        boolean allLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        boolean allSameVal = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;

        if(allLeaf && allSameVal) {
            return new Node(topLeft.val, true);
        } else {
            return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    private static final class Node {
        private boolean val;
        private boolean isLeaf;
        private Node topLeft;
        private Node topRight;
        private Node bottomLeft;
        private Node bottomRight;

        Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,1},{1,0}
        };

        Node node = ConstructQuadTree.construct(grid);
        System.out.println(node);
    }
}
