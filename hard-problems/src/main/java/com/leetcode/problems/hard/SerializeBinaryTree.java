package com.leetcode.problems.hard;

public final class SerializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        StringBuilder ser = new StringBuilder();
        serialize(root, ser);
        return ser.toString();
    }

    private void serialize(TreeNode node, StringBuilder ser) {
        if(ser.length() > 0) {
            ser.append(",");
        }
        if(node != null) {
            ser.append(node.val);
            serialize(node.left, ser);
            serialize(node.right, ser);
        } else {
            ser.append("null");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) {
            return null;
        }
        String[] tokens = data.split(",");
        return deserialize(tokens, new Counter());
    }

    private TreeNode deserialize(String[] tokens, Counter c) {
        if(c.count >= tokens.length) {
            return null;
        }

        String val = tokens[c.next()];
        if("null".equals(val)) {
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(val));
        current.left = deserialize(tokens, c);
        current.right = deserialize(tokens, c);
        return current;
    }

    private static class Counter {
        private int count;

        int next() {
            return count++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                                     new TreeNode(2,
                                                  new TreeNode(3),
                                                  new TreeNode(4)),
                                     new TreeNode(5));

        System.out.println(root);

        SerializeBinaryTree serializer = new SerializeBinaryTree();
        String serialized = serializer.serialize(root);
        System.out.println(serialized);

        TreeNode newRoot = serializer.deserialize(serialized);
        System.out.println(newRoot);
    }
}
