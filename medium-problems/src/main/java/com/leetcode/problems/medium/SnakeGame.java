package com.leetcode.problems.medium;

import java.util.*;

public final class SnakeGame {
    private static final Map<String, int[]> dirs = Map.of("U", new int[]{-1,0},
                                                          "D", new int[]{1,0},
                                                          "L", new int[]{0,-1},
                                                          "R", new int[]{0,1});

    private final int[][] food;
    private int foodIndex;
    private final Deque<Cell> snake;
    private final Set<Cell> occupied;
    private final int width;
    private final int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.food=food;
        this.foodIndex=0;
        this.snake = new LinkedList<>();
        this.occupied = new HashSet<>();
        this.width=width;
        this.height=height;

        Cell head = new Cell(0,0);
        this.snake.offer(head);
        this.occupied.add(head);
    }

    public int move(String direction) {
        int[] dir = dirs.get(direction);
        Cell head = snake.peekFirst();

        // are we out of bounds ?
        int row=head.row+dir[0], col=head.col+dir[1];
        if(row<0 || row>=height || col<0 || col>=width) {
            return -1;
        }

        // if we consumed all food or new head does not hit a food box, remove tail
        if(foodIndex >= food.length || food[foodIndex][0] != row || food[foodIndex][1] != col) {
            occupied.remove(snake.pollLast());
        } else {
            foodIndex++;
        }

        // did we hit a snake occupied cell ?
        Cell nhead = new Cell(row, col);
        if(occupied.contains(nhead)) {
            return -1;
        }

        // add the new head
        snake.offerFirst(nhead);
        occupied.add(nhead);

        // you can also use the foodIndex as they grow the same
        return snake.size()-1;
    }

    private static final class Cell {
        private final int row;
        private final int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int hashCode() {
            return Objects.hash(row, col);
        }

        public boolean equals(Object other) {
            Cell c = (Cell)other;
            return c.row == this.row && c.col == this.col;
        }
    }
}
