package com.leetcode.learning.graph.dfs;

import java.util.*;

public final class ReconstructItinerary {
    private Map<String, List<String>> adj;
    private Map<String, boolean[]> visited;
    private int n;
    private List<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.adj = new HashMap<>();
        this.visited = new HashMap<>();
        this.n = tickets.size()+1;
        this.result = Collections.emptyList();

        for(List<String> t : tickets) {
            adj.computeIfAbsent(t.get(0), k -> new ArrayList<>()).add(t.get(1));
        }
        for(String from : adj.keySet()) {
            adj.get(from).sort(Comparator.naturalOrder());
            visited.put(from, new boolean[adj.get(from).size()]);
        }

        List<String> route = new ArrayList<>();
        route.add("JFK");
        dfs("JFK", route);

        return result;
    }

    private void dfs(String from, List<String> route) {
        if(route.size() == n) {
            this.result = new ArrayList<>(route);
            return;
        }

        if(! adj.containsKey(from)) {
            return;
        }

        for(int i=0; i<adj.get(from).size(); i++) {
            if(! this.result.isEmpty()) {
                break;
            }

            if(! visited.get(from)[i]) {
                String to = adj.get(from).get(i);
                visited.get(from)[i]=true;
                route.add(to);
                dfs(to, route);
                route.remove(route.size()-1);
                visited.get(from)[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();

        // [["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],
        // ["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
        List<List<String>> tickets = List.of(List.of("EZE","AXA"), List.of("TIA","ANU"),
                                             List.of("ANU","JFK"), List.of("JFK","ANU"),
                                             List.of("ANU","EZE"), List.of("TIA","ANU"),
                                             List.of("AXA","TIA"), List.of("TIA","JFK"),
                                             List.of("ANU","TIA"), List.of("JFK","TIA"));

        System.out.println(ri.findItinerary(tickets));
    }
}
