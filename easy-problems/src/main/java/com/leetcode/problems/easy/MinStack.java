package com.leetcode.problems.easy;

public final class MinStack {
    private Node head = null;
    private int min = Integer.MAX_VALUE;

    public void push(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

        node.minBefore = min;
        min = Integer.min(min, node.value);
    }

    public void pop() {
        int value = head.value;
        min = head.minBefore;
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return min;
    }

    private static final class Node {
        private int minBefore;
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }
}
