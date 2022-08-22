package com.leetcode.problems.hard;

import java.util.*;

public final class BusRoutes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }

        final int busCount = routes.length;

        // build adj matrix for each stop.
        // connect each stop to the busses that pass from it.
        Map<Integer, List<Integer>> routesByStops = new HashMap<>();
        for(int bus=0; bus<busCount; bus++) {
            for(int r=0; r<routes[bus].length; r++) {
                routesByStops.computeIfAbsent(routes[bus][r], k -> new ArrayList<>()).add(bus);
            }
        }

        // since we do a bfs, prevent going back to where we were some cycle ago.
        Set<Integer> seenStops = new HashSet<>();
        boolean[] seenBusses = new boolean[busCount];

        Queue<BusTrip> trips = new ArrayDeque<>();
        trips.offer(new BusTrip(source, 0));
        seenStops.add(source);

        // for each 'level' we process routes that pass though a stop.
        // all the stops on selected route are directly available with same cost.
        // if we don't find target in selected routes, we extend to next 'level'.
        while(! trips.isEmpty()) {
            BusTrip trip = trips.poll();

            if(trip.stop == target) {
                return trip.busCount;
            }

            for(int bus : routesByStops.get(trip.stop)) {
                // we don't go to same route again.
                // we know target is not in that route, otherwise we wouldn't be here.
                // and there is no point in going back to a route that brought us here.
                if(! seenBusses[bus]) {
                    seenBusses[bus]=true;

                    for(int stop : routes[bus]) {
                        // similar to route, there is no point in processing a stop again that brought us here.
                        if(! seenStops.contains(stop)) {
                            seenStops.add(stop);
                            trips.offer(new BusTrip(stop, trip.busCount+1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static final class BusTrip {
        private final int stop;
        private int busCount;

        BusTrip(int stop, int busCount) {
            this.stop = stop;
            this.busCount = busCount;
        }
    }

    public static void main(String[] args) {
        int[][] routes = new int[][] {{1,2,7}, {3,6,7}};
        System.out.println(BusRoutes.numBusesToDestination(routes, 1, 6));

        routes = new int[][] {{1,9,12,20,23,24,35,38},{10,21,24,31,32,34,37,38,43},{10,19,28,37},{8},{14,19},
                {11,17,23,31,41,43,44},{21,26,29,33},{5,11,33,41},{4,5,8,9,24,44}};
        System.out.println(BusRoutes.numBusesToDestination(routes, 37, 28));
    }
}
