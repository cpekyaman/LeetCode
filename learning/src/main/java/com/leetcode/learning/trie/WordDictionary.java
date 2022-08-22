package com.leetcode.learning.trie;

public final class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            int child = c-'a';
            if(node.children[child] == null) {
                node.children[child] = new Node();
            }
            node = node.children[child];
        }
        node.word = word;
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node node, String word) {
        if(node == null) {
            return false;
        }

        for(int i=0; i<word.length(); i++) {
            // if current char is wildcard, descent into children for the remainder of the word
            if(word.charAt(i) == '.') {
                for(Node cn : node.children) {
                    if(search(cn, word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            } else {
                // if match descent into child else no match and return false
                int child = word.charAt(i)-'a';
                if(node.children[child] != null) {
                    node = node.children[child];
                } else {
                    return false;
                }
            }
        }

        return node.word != null;
    }

    private static final class Node {
        private String word;
        private final Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }
}
