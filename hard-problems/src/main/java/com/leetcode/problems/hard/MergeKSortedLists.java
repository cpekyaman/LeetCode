package com.leetcode.problems.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class MergeKSortedLists {
    public ListNode merge(ListNode[] lists) {

        PriorityQueue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for(ListNode head : lists) {
            if(head != null) {
                nodes.add(head);
            }
        }

        ListNode head=null, current = null;
        while(! nodes.isEmpty()) {
            ListNode node = nodes.poll();
            if(head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }

            if(node.next != null) {
                nodes.add(node.next);
            }
        }

        return head;
    }
}
