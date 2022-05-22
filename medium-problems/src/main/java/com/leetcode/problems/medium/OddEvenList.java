package com.leetcode.problems.medium;

public final class OddEvenList {
    public static ListNode reorder(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode ehead = new ListNode(0);
        ListNode onode = head, enode = ehead;

        while(onode.next != null) {
            enode.next = onode.next;
            enode = enode.next;

            onode.next = onode.next.next;
            if(onode.next != null) {
                onode = onode.next;
            }
        }

        enode.next = null;
        onode.next = ehead.next;
        return head;
    }
}
