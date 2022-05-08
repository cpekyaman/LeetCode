package com.leetcode.problems.easy;

public final class DeleteNodeInLinkedList {
    public static void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
