package com.leetcode.learning.narytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public final class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) {
            return null;
        }

        TreeNode btreeRoot = new TreeNode(root.val);

        Queue<Pair> bfs = new ArrayDeque<>();
        bfs.offer(new Pair(root, btreeRoot));

        while(! bfs.isEmpty()) {
            int sz = bfs.size();

            for(int i=0; i<sz; i++) {
                Pair p = bfs.poll();

                if(p.naryNode.children != null) {
                    TreeNode head = null, prev=null;
                    for(Node child : p.naryNode.children) {
                        TreeNode tn = new TreeNode(child.val);
                        if(prev == null) {
                            head = tn;
                        } else {
                            prev.right=tn;
                        }
                        prev = tn;
                        bfs.offer(new Pair(child, tn));
                    }
                    p.btreeNode.left = head;
                }
            }
        }

        return btreeRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) {
            return null;
        }

        Node naryRoot = new Node(root.val, new ArrayList<>());

        Queue<Pair> bfs = new ArrayDeque<>();
        bfs.offer(new Pair(naryRoot, root));

        while(! bfs.isEmpty()) {
            int sz = bfs.size();

            for(int i=0; i<sz; i++) {
                Pair p = bfs.poll();

                if(p.btreeNode.left != null) {
                    TreeNode left = p.btreeNode.left;
                    TreeNode next = left;
                    while(next != null) {
                        Node naryNode = new Node(next.val, new ArrayList<>());
                        p.naryNode.children.add(naryNode);

                        bfs.offer(new Pair(naryNode, next));

                        next = next.right;
                    }
                }
            }
        }

        return naryRoot;
    }

    private static final class Pair {
        private final Node naryNode;
        private final TreeNode btreeNode;

        Pair(Node n, TreeNode tn) {
            this.naryNode = n;
            this.btreeNode = tn;
        }
    }
}
