package com.leetcode.problems.easy;

public final class PalindromeList {
    public static boolean check(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rhead = reverse(slow);
        boolean ans = true;
        while(rhead != null && head != null) {
            if(rhead.val != head.val) {
                ans=false;
                break;
            }
            rhead = rhead.next;
            head = head.next;
        }
        reverse(rhead);
        return ans;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static class ListNode {
        private final int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
