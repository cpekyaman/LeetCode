package com.leetcode.learning.trie;

import java.util.*;

public final class AutocompleteSystem {
    private static final char END = '#';
    private static final int HOT_SIZE = 3;

    private Node trieRoot;
    private StringBuilder prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.prefix = new StringBuilder();
        for(int i=0; i<sentences.length; i++) {
            trieRoot = insert(trieRoot, sentences[i], times[i], 0);
        }
    }

    public List<String> input(char c) {
        if(c == END) {
            saveInput();
            return Collections.emptyList();
        }

        prefix.append(c);
        return autocomplete();
    }

    private List<String> autocomplete() {
        String str = prefix.toString();
        // we use min heap as we constantly remove the head if it is least hot.
        Queue<SearchResult> queue = new PriorityQueue<>((a,b) -> {
            int comp = Integer.compare(a.rank, b.rank);
            if(comp == 0) {
                return b.text.compareTo(a.text);
            }
            return comp;
        });
        collect(get(trieRoot, str, 0), str, queue);

        // the results come from minheap, we add them reverse order
        List<String> ans = new LinkedList<>();
        while(!queue.isEmpty()) {
            ans.add(0, queue.poll().text);
        }
        return ans;
    }

    private void saveInput() {
        if(prefix.length() == 0) {
            return;
        }

        String str = prefix.toString();
        Node existing = get(trieRoot, str, 0);
        if(existing != null && existing.value != null) {
            existing.value = existing.value+1;
        } else {
            insert(trieRoot, str, 1, 0);
        }
        prefix = new StringBuilder();
    }

    private void collect(Node root, String prefix, Queue<SearchResult> result) {
        if(root == null) {
            return;
        }

        if(root.value != null) {
            result.offer(new SearchResult(prefix, root.value));
            // keeping the size at HOT_SIZE, pop the least hot item
            if(result.size() > HOT_SIZE) {
                result.poll();
            }
        }

        for(char c : root.next.keySet()) {
            collect(root.next.get(c), prefix+c, result);
        }
    }

    private Node get(Node node, String key, int level) {
        if(node == null) {
            return null;
        }

        if(key.length() == level) {
            return node;
        }
        return get(node.next.get(key.charAt(level)), key, level+1);
    }

    private Node insert(Node node, String key, int value, int level) {
        if(node == null) {
            node = new Node(null);
        }

        if(level == key.length()) {
            node.value = value;
            return node;
        }

        char ch = key.charAt(level);
        Node child = node.next.get(ch);
        if(child == null) {
            child = insert(child, key, value, level+1);
            node.next.put(ch, child);
        } else {
            insert(child, key, value, level+1);
        }
        return node;
    }

    private static final class SearchResult {
        private final String text;
        private final int rank;

        SearchResult(String text, int rank) {
            this.text = text;
            this.rank = rank;
        }
    }

    private static final class Node {
        private Integer value;
        private final Map<Character, Node> next;

        Node(Integer value) {
            this.value = value;
            this.next = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem as = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                                                       new int[]{5, 3, 2, 2});

        System.out.println(as.input('i'));
        System.out.println(as.input(' '));
        System.out.println(as.input('a'));
        System.out.println(as.input('#'));

        System.out.println(as.input('i'));
        System.out.println(as.input(' '));
        System.out.println(as.input('a'));
        System.out.println(as.input('#'));

        System.out.println(as.input('i'));
        System.out.println(as.input(' '));
        System.out.println(as.input('a'));
        System.out.println(as.input('#'));
    }
}
