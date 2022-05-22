package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

public final class CopyListWithRandomPointer {
    public static Node copy(Node head) {
        if(head == null) {
            return head;
        }

        Map<Node, Node> newNodes = new HashMap<>();

        Node nhead = new Node(head.val);
        Node old = head, clone = nhead;

        while(old != null) {
            newNodes.putIfAbsent(old, clone);

            if(old.next != null) {
                clone.next = newNodes.computeIfAbsent(old.next, n -> new Node(n.val));
            }

            if(old.random != null) {
                clone.random = newNodes.computeIfAbsent(old.random, n-> new Node(n.val));
            }

            old = old.next;
            clone = clone.next;
        }

        return nhead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
