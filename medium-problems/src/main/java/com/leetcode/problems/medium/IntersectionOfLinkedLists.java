package com.leetcode.problems.medium;

public final class IntersectionOfLinkedLists {
    public static ListNode find(ListNode headA, ListNode headB) {
        ListNode anode = headA, bnode= headB;

        while(anode != bnode) {
            anode = anode == null ? headB : anode.next;
            bnode = bnode == null ? headA : bnode.next;
        }
        return anode;
    }
}
