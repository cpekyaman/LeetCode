package com.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class ExclusiveTimeOfFunctions {
    public static int[] exclusiveTime(int n, List<String> logs) {

        int[] execTimes = new int[n];

        // each item is {id, time}, we only push start items
        Deque<int[]> callStack = new ArrayDeque<>();

        for(String logStr : logs) {
            String[] log = logStr.split(":");
            if(log[1].equals("start")) {
                callStack.push(new int[]{Integer.parseInt(log[0]), Integer.parseInt(log[2])});
            } else {
                int[] func = callStack.pop();
                int duration = Integer.parseInt(log[2]) - func[1] + 1;
                execTimes[func[0]] += duration;
                // we deduce the running time of finished function from its caller
                if(! callStack.isEmpty()) {
                    execTimes[callStack.peek()[0]] -= duration;
                }
            }
        }

        return execTimes;
    }
}
