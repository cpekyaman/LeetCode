package com.leetcode.problems.medium;

public class InsertIntoCyclicSortedList {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node nhead = new Node(insertVal);
            nhead.next=nhead;
            return nhead;
        }

        // insertVal: 6
        // 1. in order: 3 4 . 7
        // 2. max: 3 5 . 1
        // 3. min: 8 9 . 7
        // 3. all equal: 6 6 . 6
        Node prev = head, next=head.next;
        while(next != head) {
            if(prev.val <= next.val) {
                if(insertVal >= prev.val && insertVal <= next.val) {
                    break;
                }
            } else if(insertVal >= prev.val || insertVal <= next.val) {
                break;
            }

            prev = next;
            next = next.next;
        }

        prev.next = new Node(insertVal);
        prev.next.next = next;

        return head;
    }

    final static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
