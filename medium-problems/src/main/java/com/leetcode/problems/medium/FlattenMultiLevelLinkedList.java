package com.leetcode.problems.medium;

public final class FlattenMultiLevelLinkedList {
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }

        Node curr = head;
        while(curr != null) {
            if(curr.child == null) {
                curr = curr.next;
                continue;
            }

            // connect last child with next of curr
            Node nested = curr.child;
            while(nested.next != null) {
                nested = nested.next;
            }
            nested.next = curr.next;
            if(curr.next != null) {
                curr.next.prev = nested;
            }

            // connect current and its child
            curr.next = curr.child;
            curr.child.prev=curr;
            curr.child=null;

            curr=curr.next;
        }
        return head;
    }

    final static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
