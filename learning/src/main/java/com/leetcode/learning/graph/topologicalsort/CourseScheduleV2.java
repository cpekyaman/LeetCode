package com.leetcode.learning.graph.topologicalsort;

import java.util.*;

// v1 is the same, it just wants if the result can be achieved
public final class CourseScheduleV2 {
    // using kahn's topological sort algo
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build adj lists and some supporting data
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] p : prerequisites) {
            adj.computeIfAbsent(p[1], c -> new HashSet<>()).add(p[0]);
            indegree[p[0]]+=1;
        }

        Queue<Integer> nodepCourses = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
                nodepCourses.add(i);
            }
        }

        int added=0;
        int[] ans = new int[numCourses];
        while(! nodepCourses.isEmpty()) {
            int course = nodepCourses.poll();
            ans[added++]=course;

            if(! adj.containsKey(course)) {
                continue;
            }

            for(int next : adj.get(course)) {
                indegree[next]-=1;
                if(indegree[next] == 0) {
                    nodepCourses.add(next);
                }
            }
        }

        if(added == numCourses) {
            return ans;
        }
        return new int[0];
    }
}
