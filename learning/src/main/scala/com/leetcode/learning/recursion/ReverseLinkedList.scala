package com.leetcode.learning.recursion

object ReverseLinkedList {
  def reverse(head: ListNode): ListNode = {
    if(head == null || head.next == null) {
      return head
    }

    // we go all the way to the last node
    val nHead = reverse(head.next)

    // recursion n: 4 -> 5 becomes 5 -> 4
    // recursion n-1: 3 -> 4 becomes 4 -> 3
    // recursion 0: 1 -> 2 becomes 2 -> 1
    head.next.next = head
    head.next = null

    nHead
  }
}
