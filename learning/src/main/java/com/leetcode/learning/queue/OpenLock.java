package com.leetcode.learning.queue;

import java.util.*;

public final class OpenLock {
    public static int openLock(String[] deadends, String target) {
        final char[][] states = new char[][]{
                {'1','2','3','4','5','6','7','8','9','0'},
                {'9','0','1','2','3','4','5','6','7','8'}
        };
        final Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        final Set<String> seen = new HashSet<>();
        seen.add("0000");

        Queue<char[]> bfs = new ArrayDeque<>();
        bfs.offer(new char[]{'0','0','0','0'});

        int depth=0;
        while(! bfs.isEmpty()) {
            int sz = bfs.size();
            for(int i=0; i<sz; i++) {
                char[] state = bfs.poll();

                String stateStr = new String(state);
                if(stateStr.equals(target)) {
                    return depth;
                }
                if(deadendSet.contains(stateStr)) {
                    continue;
                }

                for(int w=0; w<4; w++) {
                    for(char[] s : states) {
                        char[] newstate = new char[]{state[0],state[1],state[2],state[3]};
                        newstate[w] = s[newstate[w]-'0'];
                        String str = new String(newstate);
                        if(! seen.contains(str)) {
                            seen.add(str);
                            bfs.offer(newstate);
                        }
                    }
                }
            }
            depth++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(OpenLock.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }
}
