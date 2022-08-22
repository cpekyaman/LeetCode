package com.leetcode.learning.graph.topologicalsort;

import java.util.*;

public final class AlienDictionary {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }

        Map<Character, List<Character>> adjMatrix = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(String word : words) {
            for(int c=0; c < word.length(); c++) {
                adjMatrix.put(word.charAt(c), new LinkedList<>());
                inDegree.put(word.charAt(c), 0);
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String left = words[i], right=words[i+1];

            if(left.length() > right.length() && left.startsWith(right)) {
                return "";
            }

            int len = Integer.min(left.length(), right.length());
            for(int c=0; c < len; c++) {
                char lc = left.charAt(c), rc = right.charAt(c);
                if(lc != rc) {
                    adjMatrix.get(lc).add(rc);
                    inDegree.compute(rc, (k,v) -> v+1);
                    break;
                }
            }
        }

        Queue<Character> sources = new LinkedList<>();
        for(Character c : inDegree.keySet()) {
            if(inDegree.get(c) == 0) {
                sources.offer(c);
            }
        }

        StringBuilder alphabet = new StringBuilder();
        while(! sources.isEmpty()) {
            Character src = sources.poll();
            alphabet.append(src);

            for(Character c : adjMatrix.get(src)) {
                inDegree.put(c, inDegree.get(c) - 1);
                if(inDegree.get(c) == 0) {
                    sources.offer(c);
                }
            }
        }

        if(alphabet.length() < inDegree.size()) {
            return "";
        }
        return alphabet.toString();
    }
}
