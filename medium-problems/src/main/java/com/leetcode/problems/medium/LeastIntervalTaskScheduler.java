package com.leetcode.problems.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public final class LeastIntervalTaskScheduler {
    public static int schedule(char[] tasks, int n) {
        if(n == 0) {
            return tasks.length;
        }

        int[] counts = new int[26];
        for(char c : tasks) {
            counts[c - 'A'] += 1;
        }

        PriorityQueue<Character> ordered = new PriorityQueue<>((t1, t2) -> Integer.compare(counts[t2-'A'], counts[t1-'A']));
        for(int i=0; i<26; i++) {
            if(counts[i] > 0) {
                ordered.add((char)('A'+i));
            }
        }

        int interval=tasks.length;
        List<Character> cooldown = new LinkedList<>();
        while(! ordered.isEmpty()) {
            int runCount=n+1;
            while(runCount > 0 && ! ordered.isEmpty()) {
                Character task = ordered.poll();
                counts[task-'A']-=1;
                if(counts[task-'A'] > 0) {
                    cooldown.add(task);
                }
                runCount--;
            }

            ordered.addAll(cooldown);
            cooldown.clear();

            if(! ordered.isEmpty()) {
                interval += runCount;
            }
        }
        return interval;
    }

    public static void main(String[] args) {
        System.out.println(LeastIntervalTaskScheduler.schedule(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(LeastIntervalTaskScheduler.schedule(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(LeastIntervalTaskScheduler.schedule(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}
