package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

public final class SearchSuggestionSystem {
    public List<List<String>> suggest(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String p : products) {
            trie.insert(p);
        }

        List<List<String>> ans = new ArrayList<>();
        String prefix="";
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            ans.add(trie.keysWithPrefix(prefix));
        }
        return ans;
    }

    private static final class Trie {
        private final Node root;

        Trie() {
            this.root = new Node('\u0000');
        }

        private void insert(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node(c);
                }
                node = node.children[c - 'a'];
            }
            node.value = s;
        }

        private List<String> keysWithPrefix(String prefix) {
            List<String> keys = new ArrayList<>(3);
            Node node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return keys;
                }
                node = node.children[c - 'a'];
            }
            searchWithPrefix(node, keys);
            return keys;
        }

        private void searchWithPrefix(Node node, List<String> keys) {
            if (keys.size() == 3) {
                return;
            }

            if (node.value != null) {
                keys.add(node.value);
            }

            for (int i = 0; i < 26; i++) {
                if (keys.size() == 3) {
                    break;
                }
                if (node.children[i] != null) {
                    searchWithPrefix(node.children[i], keys);
                }
            }
        }

        private static final class Node {
            private char c;
            private String value;
            private Node[] children;

            Node(char c) {
                this.c = c;
                this.children = new Node[26];
            }
        }
    }
}
