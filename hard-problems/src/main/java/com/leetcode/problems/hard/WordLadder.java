package com.leetcode.problems.hard;

import java.util.*;

public final class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // easier to use a set when we later check if a word is in the list
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);

        if(! words.contains(endWord)) {
            return 0;
        }

        // we'll build paths starting from begin word in a bfs manner.
        // once we reach the endWord, we know we reach the shortest level.
        Set<String> visited = new HashSet<>();
        Queue<String> pathWords = new ArrayDeque<>();

        pathWords.add(beginWord);
        visited.add(beginWord);

        int level=1;
        while(! pathWords.isEmpty()) {
            int sz = pathWords.size();

            // for each path in the queue at this level, find the next set of words can be added.
            // if any of the new paths reach end word add them to answer,
            // otherwise add them to queue for processing for next level / depth.
            for(int i=0; i<sz; i++) {
                String previousWordOfPath = pathWords.poll();
                List<String> nextWords = getNeighbors(previousWordOfPath, words);
                for(String next : nextWords) {
                    if(! visited.contains(next)) {
                        visited.add(next);
                        if(next.equals(endWord)) {
                            return level + 1;
                        } else {
                            pathWords.offer(next);
                        }
                    }
                }
            }

            level+=1;
        }

        return 0;
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

    // "ymain"
    //"oecij"
    //["ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"]
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("ymain", "oecij",
                                                         List.of("ymann","yycrj","oecij","ymcnj","yzcrj",
                                                                 "yycij","xecij","yecij","ymanj","yzcnj","ymain")));
    }
}
