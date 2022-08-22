package com.leetcode.learning.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public final class PerfectSquares {
    public static int numSquares(int n) {
        int squaresCount = (int) Math.sqrt(n) + 1;

        List<Integer> squares = new ArrayList<>(squaresCount);
        for(int i=1; i<=squaresCount; i++) {
            squares.add(i * i);
        }

        Queue<Integer> bfs = new ArrayDeque<>();
        bfs.offer(n);

        int level = 0;
        while(! bfs.isEmpty()) {
            level++;
            int sz = bfs.size();
            for(int i=0; i<sz; i++) {
                Integer num = bfs.poll();
                for(Integer sq : squares) {
                    if(sq.equals(num)) {
                        return level;
                    } else if(num < sq) {
                        break;
                    } else {
                        bfs.offer(num - sq);
                    }
                }
            }
        }
        return level;
    }
}
