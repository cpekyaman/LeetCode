package com.leetcode.problems.medium;

public final class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null, dest = null;
        while(l1 != null || l2 != null) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = sum / 10;
            if(head == null) {
                head = new ListNode(sum % 10);
                dest = head;
            } else {
                dest.next = new ListNode(sum % 10);
                dest = dest.next;
            }

            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }

        if(carry > 0) {
            dest.next = new ListNode(carry);
        }

        return head;
    }
}
