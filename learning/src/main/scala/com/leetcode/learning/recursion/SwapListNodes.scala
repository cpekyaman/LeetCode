package com.leetcode.learning.recursion

object SwapListNodes {
  def swap(head: ListNode): ListNode = {
    if(head == null || head.next == null) {
      return head
    }

    val first = head
    val second = head.next

    first.next = swap(second.next)
    second.next = first

    second
  }
}
