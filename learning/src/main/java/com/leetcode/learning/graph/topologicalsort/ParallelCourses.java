package com.leetcode.learning.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n+1];
        for(int[] rel : relations) {
            adj.computeIfAbsent(rel[0], c -> new ArrayList<>()).add(rel[1]);
            indegree[rel[1]]+=1;
        }

        List<Integer> semester = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i]==0) {
                semester.add(i);
            }
        }

        int courses=0, semesters=0;
        while(! semester.isEmpty()) {
            semesters++;
            List<Integer> nextSemester = new ArrayList<>();
            for(int course : semester) {
                courses++;
                if(! adj.containsKey(course)) {
                    continue;
                }
                for(int next : adj.get(course)) {
                    indegree[next]-=1;
                    if(indegree[next]==0) {
                        nextSemester.add(next);
                    }
                }
            }
            semester = nextSemester;
        }

        return courses == n ? semesters : -1;
    }
}
