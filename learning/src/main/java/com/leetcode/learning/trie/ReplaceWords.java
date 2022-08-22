package com.leetcode.learning.trie;

import java.util.List;

public final class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node trie = new Node();
        for(String root : dictionary) {
            insert(trie, root);
        }

        StringBuilder ans = new StringBuilder();
        for(String word : sentence.split(" ")) {
            if(ans.length() > 0) {
                ans.append(" ");
            }
            Node root = find(trie, word);
            if(root != null && root.word != null) {
                ans.append(root.word);
            } else {
                ans.append(word);
            }
        }
        return ans.toString();
    }

    private Node find(Node trie, String word) {
        Node current = trie;
        for(char c : word.toCharArray()) {
            if(current.children[c-'a'] == null || current.word != null) {
                break;
            }
            current = current.children[c-'a'];
        }
        return current;
    }

    private void insert(Node trie, String root) {
        Node current = trie;
        for(char c : root.toCharArray()) {
            if(current.children[c-'a'] == null) {
                current.children[c-'a'] = new Node();
            }
            current = current.children[c-'a'];
        }
        current.word = root;
    }

    private static final class Node {
        private String word;
        private Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }
}
