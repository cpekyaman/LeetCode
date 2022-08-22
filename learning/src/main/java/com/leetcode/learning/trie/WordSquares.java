package com.leetcode.learning.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        // we need the trie to search for words by prefix when building a candidate square
        Node trie = buildTrie(words);

        // for each word, we try to build a square with that word as the first row
        List<List<String>> ans = new ArrayList<>();
        for(String word : words) {
            LinkedList<String> current = new LinkedList<>();
            current.add(word);
            build(ans, trie, current, word.length());
        }
        return ans;
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for(String word : words) {
            Node node = root;
            for(char c : word.toCharArray()) {
                int idx = c-'a';
                if(node.children[idx]==null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }

    private void build(List<List<String>> ans, Node trie, LinkedList<String> current, int size) {
        // done for current candidate, add to result and return.
        if(current.size() == size) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // build the prefix required to be present in the next row of the candidate.
        // for the nth row, it is the nth letters of previously added words on the square.
        int step = current.size();
        StringBuilder prefix = new StringBuilder();
        for(String word : current) {
            prefix.append(word.charAt(step));
        }

        // try the next set of candidates by backtracking.
        for(String next : findWordsByPrefix(trie, prefix.toString())) {
            current.addLast(next);
            build(ans, trie, current, size);
            current.removeLast();
        }
    }

    private List<String> findWordsByPrefix(Node trie, String prefix) {
        // first finding the root node corresponding to prefix
        Node node = trie;
        for(char c : prefix.toCharArray()) {
            if(node.children[c-'a'] != null) {
                node = node.children[c-'a'];
            } else {
                return Collections.emptyList();
            }
        }

        // find all the complete words under the prefix
        List<String> results = new LinkedList<>();
        collectWords(node, results);
        return results;
    }

    // search can be speed up if we keep the list of words stored in children in the prefix nodes also.
    private void collectWords(Node node, List<String> results) {
        if(node == null) {
            return;
        }

        if(node.word != null) {
            results.add(node.word);
        }

        for(Node child : node.children) {
            if(child != null) {
                collectWords(child, results);
            }
        }
    }

    private static final class Node {
        private String word;
        private final Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }
}
