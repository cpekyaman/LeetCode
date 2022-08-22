package com.leetcode.learning.graph.shortestpath;

import java.util.*;

public final class NetworkDelayTime {
    public int find(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> adj = new HashMap<>();
        for(int[] time : times) {
            adj.computeIfAbsent(time[0], v -> new ArrayList<>())
               .add(new Edge(time[1], time[2]));
        }

        int[] signalTimes = new int[n];
        Arrays.fill(signalTimes, Integer.MAX_VALUE);

        dijkstra(adj, signalTimes, k);

        int max = Integer.MIN_VALUE;
        for(int st : signalTimes) {
            max = Integer.max(max, st);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void dijkstra(Map<Integer, List<Edge>> adj, int[] signalTimes, int src) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));

        queue.offer(new Edge(src, 0));
        signalTimes[src-1]=0;

        while(! queue.isEmpty()) {
            Edge ve = queue.remove();

            // already been here
            if(signalTimes[ve.to-1] < ve.time) {
                continue;
            }

            // no neighbour to propagate
            if(! adj.containsKey(ve.to)) {
                continue;
            }

            for(Edge we : adj.get(ve.to)) {
                // new signal time is lower, we add the vertex to queue
                if(signalTimes[we.to-1] > ve.time + we.time) {
                    signalTimes[we.to-1] = ve.time + we.time;
                    queue.offer(new Edge(we.to, signalTimes[we.to-1]));
                }
            }
        }
    }

    private static final class Edge {
        private final int to;
        private int time;

        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
}
