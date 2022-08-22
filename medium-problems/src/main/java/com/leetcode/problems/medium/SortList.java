package com.leetcode.problems.medium;

public final class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    // this is the same as 'merge two sorted lists question'.
    // as two of the sublists will be sorted when we reach here.
    // base condition is one element lists.
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head=new ListNode(-1);
        ListNode prev=head;
        while(left != null && right != null) {
            if(left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }

        prev.next = (left != null ? left : right);

        return head.next;
    }

    // using two pointers approach for finding the mid
    private ListNode findMid(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // the mid will become the head of a sublist.
        // we remove the next of prev to do prevent two sublists to stay connected.
        prev.next = null;
        return slow;
    }
}
