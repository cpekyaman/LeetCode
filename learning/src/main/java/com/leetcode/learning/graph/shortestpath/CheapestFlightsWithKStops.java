package com.leetcode.learning.graph.shortestpath;

import java.util.Arrays;

public class CheapestFlightsWithKStops {
    // a modified version of bellman-ford / SPFA.
    // it is essentially a prev-curr array version of DP.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src]=0;

        // relax the edges k+1 times (src + k-stops + dst = k+2 vertices)
        for(int iter=0; iter<k+1; iter++) {
            int[] currCost = Arrays.copyOf(costs, n);
            for(int f=0; f<flights.length; f++) {
                int[] flight = flights[f];
                int v=flight[0], w=flight[1], cost=flight[2];

                if(costs[v]==Integer.MAX_VALUE) {
                    continue;
                }

                if(costs[v] + cost < currCost[w]) {
                    currCost[w] = costs[v] + cost;
                }
            }
            costs = currCost;
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
