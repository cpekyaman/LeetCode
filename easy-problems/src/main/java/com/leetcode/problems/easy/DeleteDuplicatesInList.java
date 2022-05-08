package com.leetcode.problems.easy;

public final class DeleteDuplicatesInList {

    public static ListNode delete(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode current = head.next;
        while(current != null) {
            if(current.val == prev.val) {
                ListNode temp = current.next;
                prev.next = temp;
                current.next = null;
                current = temp;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    private static final class ListNode {
        private final int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
