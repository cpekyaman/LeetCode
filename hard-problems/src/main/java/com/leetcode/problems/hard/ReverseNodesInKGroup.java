package com.leetcode.problems.hard;

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode previous = null, current = head;
        while(current != null) {
            // this node points to the node just before the part we are going to reverse.
            ListNode nodeBeforeNextHead = previous;
            // this node points to start of current part which will become the tail after reversal.
            ListNode newTailOfCurrentPart = current;

            // this part is to determine if we have k nodes left
            int cnt=0;
            while(current != null && cnt < k) {
                current = current.next;
                cnt++;
            }
            // not enough nodes left, stop
            if(cnt < k) {
                break;
            }
            // we will reverse the part, restore current first
            current = newTailOfCurrentPart;

            // this is standard inked list reversal starting at current.
            // at the end of loop:
            // previous will point to new head of this part.
            // current will point to the start of next part to be reversed.
            // the endpoints will properly be connected after this loop.
            for(int i=0; i < k && current != null; i++) {
                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }

            // connect the tail of previous reversed part to the head of current reversed part
            if(nodeBeforeNextHead != null) {
                nodeBeforeNextHead.next = previous;
            } else {
                head = previous;
            }

            // connect the current tail to the start of next (to-be-reversed) part
            newTailOfCurrentPart.next = current;
            // tail of current reversed list will be the previous node of next part
            previous = newTailOfCurrentPart;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode reverse = ReverseNodesInKGroup.reverseKGroup(head, 3);

        while(reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
