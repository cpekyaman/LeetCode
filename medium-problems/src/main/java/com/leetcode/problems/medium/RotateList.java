package com.leetcode.problems.medium;

public final class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode last=head, end=head.next;
        int size=1;
        while(end != null) {
            last=last.next;
            end=end.next;
            size++;
        }

        int rotate=(size - k%size);
        if(rotate == size) {
            return head;
        }

        ListNode prev=head, curr=head;
        while(rotate > 0) {
            prev = curr;
            curr = curr.next;
            rotate--;
        }

        prev.next = null;
        last.next = head;
        return curr;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev=null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for(int i = 2; i<= 5; i++) {
            prev.next = new ListNode(i);
            prev = prev.next;
        }

        System.out.println(RotateList.rotateRight(head, 2));
    }
}
