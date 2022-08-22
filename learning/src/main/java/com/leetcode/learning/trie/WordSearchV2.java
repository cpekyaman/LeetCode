package com.leetcode.learning.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class WordSearchV2 {
    private static final int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

    private Set<String> result;

    // we can use the board itself instead of visited.
    // we just need to set a cell to a non-existing value and then restore it.
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        this.result = new HashSet<>();
        this.visited = new boolean[board.length][board[0].length];

        // the trie will be used by search to reduce search space.
        // if we don't find a certain prefix in the trie, we won't go further.
        Node trie = buildTrie(words);

        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                char c = board[row][col];
                if(trie.contains(c)) {
                    search(board, trie.child(c), row, col);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void search(char[][] board, Node node, int row, int col) {
        if(visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        // a word is found, adding to result.
        // we can also do word pruning by setting a found node's value to null.
        // as we don't need to count matches.
        // this will remove the need to use set.
        if(node.value != null && ! result.contains(node.value)) {
            result.add(node.value);
        }

        // move further into children for possible adjacent directions.
        // we can do a child pruning by removing the nodes that have empty children.
        // (starting from the leaf nodes).
        for(int[] dir : dirs) {
            int nrow = row + dir[0], ncol=col+dir[1];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length) {
                char childChar = board[nrow][ncol];
                if(node.contains(childChar)) {
                    search(board, node.child(childChar), nrow, ncol);
                }
            }
        }

        visited[row][col] = false;
    }

    private Node buildTrie(String[] words) {
        Node trie = new Node();
        for(String word : words) {
            Node current = trie;
            for(char c : word.toCharArray()) {
                int idx = c-'a';
                if(current.children[idx] == null) {
                    current.children[idx] = new Node();
                }
                current = current.children[idx];
            }
            current.value = word;
        }
        return trie;
    }

    private static final class Node {
        private String value;
        private final Node[] children;

        Node() {
            this.children = new Node[26];
        }

        boolean contains(char c) {
            return children[c-'a'] != null;
        }

        Node child(char c) {
            return children[c-'a'];
        }

        void remove(char c) {
            children[c-'a']=null;
        }
    }
}
