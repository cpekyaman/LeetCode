package com.leetcode.problems.hard;

import java.util.ArrayList;
import java.util.List;

public final class SerializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder ans = new StringBuilder();
        serialize(root, ans);
        return ans.toString();
    }

    private void serialize(Node node, StringBuilder ans) {
        if(ans.length() > 0) {
            ans.append(',');
        }

        if(node == null) {
            ans.append("-");
            return;
        }

        ans.append(node.val).append(',');
        if(node.children != null) {
            ans.append(node.children.size());
            for(Node child : node.children) {
                serialize(child, ans);
            }
        } else {
            ans.append(0);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        String[] tokens = data.split(",");
        return deserialize(tokens, new Counter());
    }

    private Node deserialize(String[] tokens, Counter c) {
        String val = tokens[c.count++];
        if(val.equals("-")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(val));
        int childCount = Integer.parseInt(tokens[c.count++]);
        root.children = new ArrayList<>();
        if(childCount > 0) {
            for(int i=0; i<childCount; i++) {
                root.children.add(deserialize(tokens, c));
            }
        }
        return root;
    }

    private static final class Counter {
        private int count;
    }

    public static void main(String[] args) {
        Node two = new Node(2);
        Node three = new Node(3, List.of(new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14)))))));
        Node four = new Node(4, List.of(new Node(8, List.of(new Node(12)))));
        Node five = new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10)));

        Node root = new Node(1, List.of(two ,three, four, five));

        SerializeNaryTree ser = new SerializeNaryTree();
        String serialized = ser.serialize(root);
        System.out.println(serialized);
        Node deserialized = ser.deserialize(serialized);
        System.out.println(deserialized);
    }
}
