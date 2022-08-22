package com.leetcode.problems.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {
    // we will pay worker W with price P its minimum wage.
    // then, we can pay any worker V with quality Q and price < P at least their minimum wage by using Q*P.
    // we have to use same P for all in the selected group to obey the first rule.
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        final int n = quality.length;
        Worker[] workers = new Worker[n];
        for(int i=0; i<n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        // workers sorted by their price(cost per unit of quality).
        // when we iterate over this array, we know that any worker we see before has price < P.
        Arrays.sort(workers);


        // we keep only k of the lowest quality workers as that will give min total cost for the same price.
        // we will essentially have running sum of the lowest quality k workers.
        PriorityQueue<Worker> wq = new PriorityQueue<>(Comparator.comparing(w -> w.quality,
                                                                            Comparator.reverseOrder()));
        int qSum=0;
        double ans = Double.MAX_VALUE;
        for(Worker w : workers) {
            qSum += w.quality;
            wq.offer(w);

            // we will be polling the worker with the highest quality.
            if(wq.size() > k) {
                qSum -= wq.poll().quality;
            }

            // we have our windows size (our worker count target), calculate possible min cost.
            if(wq.size() == k) {
                ans=Math.min(ans, qSum * w.price());
            }
        }

        return ans;
    }

    private static final class Worker implements Comparable<Worker> {
        private final int quality;
        private final int minWage;

        Worker(int q, int w) {
            this.quality = q;
            this.minWage = w;
        }

        double price() {
            return (double) minWage / quality;
        }

        public int compareTo(Worker other) {
            return Double.compare(this.price(), other.price());
        }
    }
}
