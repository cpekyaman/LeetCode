package com.leetcode.problems.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class EmployeeFreeTime {
    // if we combine all the lists into a single list and sort it,
    // we can find free time by adding gaps between each successive interval.
    // since the individual lists are already sorted we'll use a different approach.
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        // we'll sort interval by their start time
        PriorityQueue<EmployeeInterval> pq = new PriorityQueue<>(Comparator.comparingInt(ei -> ei.interval.start));

        // put the first interval of each employee into queue
        for(int i=0; i<schedule.size(); i++) {
            pq.offer(new EmployeeInterval(i, 0, schedule.get(i).get(0)));
        }

        List<Interval> ans = new ArrayList<>();

        // for each interval, we compare it with the previous one.
        // if there is a gap then there is a free time.
        // since each list is ordered by themselves, we know the gap is common.
        Interval previous=null;
        while(! pq.isEmpty()) {
            EmployeeInterval current = pq.poll();
            if(previous == null) { // just the start condition
                previous = current.interval;
            } else if(previous.end < current.interval.start) { // no overlap, free time
                ans.add(new Interval(previous.end, current.interval.start));
                previous = current.interval;
            } else if(previous.end < current.interval.end) { // update previous if current ends later
                previous = current.interval;
            }

            // we removed an interval for an employee, add the next of it
            if(schedule.get(current.employee).size() > current.index + 1) {
                pq.offer(new EmployeeInterval(current.employee, current.index+1,
                                              schedule.get(current.employee).get(current.index+1)));
            }
        }

        return ans;
    }

    private static final class EmployeeInterval {
        private final int employee;
        private final int index;
        private final Interval interval;

        EmployeeInterval(int emp, int idx, Interval iv) {
            this.employee = emp;
            this.index = idx;
            this.interval = iv;
        }
    }
}
