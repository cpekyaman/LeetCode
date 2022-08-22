package com.leetcode.learning.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public final class AllPathsFromSourceLeadToDest {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Vertex[] graph = new Vertex[n];
        for(int[] edge : edges) {
            Vertex v = graph[edge[0]];
            if(v == null) {
                v = new Vertex();
                graph[edge[0]]=v;
            }
            v.adj.add(edge[1]);
        }

        // for standard visited check
        boolean[] visited = new boolean[n];
        // for checking for cycles (backward edges)
        boolean[] onstack = new boolean[n];

        return dfs(graph, visited, onstack, source, destination);
    }

    private boolean dfs(Vertex[] graph, boolean[] visited, boolean[] onstack, int src, int dest) {
        visited[src]=true;
        // if we end up at a vertex no adj, it should be dest
        if(graph[src] == null || graph[src].adj.isEmpty()) {
            return src == dest;
        }

        onstack[src]=true;

        for(int w : graph[src].adj) {
            if(! visited[w]) {
                if(! dfs(graph, visited, onstack, w, dest)) {
                    return false;
                }
            } else if(onstack[w]) { // there is a cycle
                return false;
            }
        }
        onstack[src]=false;
        return true;
    }

    private static final class Vertex {
        private List<Integer> adj;

        Vertex() {
            this.adj = new ArrayList<>();
        }
    }
}
