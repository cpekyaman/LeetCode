package com.leetcode.problems.medium;

public final class RemoveNthFromEndOfList {
    public static ListNode remove(ListNode head, int n) {
        ListNode nhead = new ListNode(0);
        nhead.next = head;

        ListNode fast = nhead;
        int iter = 0;
        while(iter <= n && fast != null) {
            fast = fast.next;
            iter++;
        }

        ListNode slow = nhead;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return nhead.next;
    }

    private static class ListNode {
        private final int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
