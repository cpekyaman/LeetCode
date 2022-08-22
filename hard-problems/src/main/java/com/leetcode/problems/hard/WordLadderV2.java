package com.leetcode.problems.hard;

import java.util.*;

public final class WordLadderV2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // easier to use a set when we later check if a word is in the list
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);

        List<List<String>> ans = new ArrayList<>();
        if(! words.contains(endWord)) {
            return ans;
        }

        // we'll build paths starting from begin word in a bfs manner.
        // once we reach the endWord, we know they are the shortest paths.
        Set<String> visited = new HashSet<>();
        Queue<List<String>> paths = new ArrayDeque<>();

        paths.add(List.of(beginWord));
        visited.add(beginWord);

        while(! paths.isEmpty()) {
            int sz = paths.size();

            // for each path in the queue at this level, find the next set of words can be added.
            // if any of the new paths reach end word add them to answer,
            // otherwise add them to queue for processing for next level / depth.
            for(int i=0; i<sz; i++) {
                List<String> path = paths.poll();
                List<String> nextWords = getNeighbors(path.get(path.size()-1), words);
                for(String next : nextWords) {
                    visited.add(next);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(next);
                    if(next.equals(endWord)) {
                        ans.add(newPath);
                    } else {
                        paths.offer(newPath);
                    }
                }
            }

            // if we've seen a word, it is already part of a path.
            // there is no point in keeping it in the input.
            words.removeAll(visited);
            visited.clear();

            // this is bfs, once we have at least one path, it is the shortest path.
            // the next level can not be shorter than current ones.
            if(ans.size() > 0) {
                break;
            }
        }

        return ans;
    }

    private List<String> getNeighbors(String word, Set<String> words) {
        char[] current = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        // for each char position change the letter,
        // and check if a word with that transform exists.
        for(int i=0; i<current.length; i++) {
            for(char c='a'; c<='z'; c++) {
                if(c == current[i]) {
                    continue;
                }

                char old = current[i];
                current[i]=c;
                String str = new String(current);
                if(words.contains(str)) {
                    neighbors.add(str);
                }
                current[i]=old;
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadderV2().findLadders("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
        System.out.println(new WordLadderV2().findLadders("hot", "dog", List.of("hot","dog", "dot")));
    }
}
