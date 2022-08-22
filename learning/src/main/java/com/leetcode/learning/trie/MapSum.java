package com.leetcode.learning.trie;

public final class MapSum {
    private final Node root;

    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node current = root;
        for(char c : key.toCharArray()) {
            int child = c-'a';
            if(current.children[child] == null) {
                current.children[child] = new Node();
            }
            current = current.children[child];
        }
        current.value = val;
    }

    public int sum(String prefix) {
        // find the prefix node first
        Node current = root;
        for(char c : prefix.toCharArray()) {
            current = current.children[c-'a'];
            if(current == null) {
                return 0;
            }
        }

        return sum(current);
    }

    private int sum(Node node) {
        if(node == null) {
            return 0;
        }

        int sum = node.value != null ? node.value : 0;
        for(Node child : node.children) {
            sum+=sum(child);
        }
        return sum;
    }

    private static final class Node {
        private Integer value;
        private final Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }
}
