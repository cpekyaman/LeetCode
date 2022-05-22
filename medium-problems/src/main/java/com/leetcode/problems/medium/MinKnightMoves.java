package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public final class MinKnightMoves {
    public static int solve(int x, int y) {
        // size=300 + 0 + offset
        Map<String, Integer> memo = new HashMap<>();
        return dfs(Math.abs(x), Math.abs(y), memo);
    }

    private static int dfs(int x, int y, Map<String, Integer> memo) {
        String cell = x + "," + y;
        if(memo.containsKey(cell)) {
            return memo.get(cell);
        }

        if(x == 0 && y == 0) {
            return 0;
        } else if(x+y == 2) {
            return 2;
        } else {
            int dist = Math.min(dfs(Math.abs(x-1), Math.abs(y-2), memo),
                                dfs(Math.abs(x-2), Math.abs(y-1), memo)) + 1;
            memo.put(cell, dist);
            return dist;
        }
    }

    private static int bfs(int x, int y) {
        int[][] moves = {
                {-2,-1}, {-1,-2}, {1,-2}, {2,-1},
                {2,1}, {1,2}, {-1,2}, {-2,1}
        };

        int steps = 0;
        Queue<int[]> cells = new ArrayDeque<>();
        boolean[][] visited = new boolean[605][605];

        cells.offer(new int[]{0,0});

        while(! cells.isEmpty()) {
            int size = cells.size();
            for(int i=0; i<size; i++) {
                int[] cell = cells.poll();
                if(cell[0] == x && cell[1]==y) {
                    return steps;
                }

                for(int[] move : moves) {
                    int[] next = new int[]{cell[0] + move[0], cell[1]+move[1]};

                    if(! visited[next[0]+302][next[1]+302]) {
                        visited[next[0]+302][next[1]+302]=true;
                        cells.offer(next);
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(MinKnightMoves.solve(2,1));
        System.out.println(MinKnightMoves.solve(5,5));
    }
}
