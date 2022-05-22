package com.leetcode.problems.medium;

public final class HitCounter {
    private final Counter[] counters;

    private int totalHits;

    private int timeStart=1;
    private int timeIndex=0;

    public HitCounter() {
        counters = new Counter[300];
        for(int i=0; i<counters.length; i++) {
            counters[i] = new Counter();
        }
    }

    public void hit(int timestamp) {
        expireOlder(timestamp);
        counters[(timeIndex + timestamp - timeStart) % 300].incr();
        totalHits++;
    }

    public int getHits(int timestamp) {
        expireOlder(timestamp);
        return totalHits;
    }

    private void expireOlder(int timestamp) {
        int expireUntil = timestamp - 300 + 1;
        int diff = expireUntil - timeStart;

        if(diff > 0) {
            for(int i=0; i<Integer.min(diff, 300); i++) {
                Counter c = counters[(timeIndex + i) % 300];
                totalHits -= c.get();
                c.reset();
            }
            timeStart=expireUntil;
            timeIndex=(timeIndex + diff) % 300;
        }
    }

    private static class Counter {
        private int count;

        void incr() {
            count++;
        }

        int get() {
            return count;
        }

        void reset() {
            count = 0;
        }
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));

        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }
}
