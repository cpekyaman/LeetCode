package com.leetcode.learning.trie;

public final class Trie {
    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node current = root;
        for(char c : word.toCharArray()) {
            int child = c-'a';
            if(current.children[child] == null) {
                current.children[child] = new Node();
            }
            current = current.children[child];
        }
        current.value = word;
    }

    public boolean search(String word) {
        Node current = root;
        for(char c : word.toCharArray()) {
            int child = c-'a';
            if(current.children[child] == null) {
                break;
            }
            current = current.children[child];
        }
        return word.equals(current.value);
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for(char c : prefix.toCharArray()) {
            current = current.children[c-'a'];
            if(current == null) {
                break;
            }
        }
        return current != null;
    }

    private static final class Node {
        private String value;
        private Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }
}
