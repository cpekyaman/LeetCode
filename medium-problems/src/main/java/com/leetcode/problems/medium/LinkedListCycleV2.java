package com.leetcode.problems.medium;

public final class LinkedListCycleV2 {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow=head;
        boolean hasCycle=false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasCycle=true;
                break;
            }
        }

        if(! hasCycle) {
            return null;
        }

        ListNode start = head;
        while(start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return start;
    }
}
